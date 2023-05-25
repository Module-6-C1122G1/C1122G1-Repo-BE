package com.example.dncinema.controller;

import com.example.dncinema.model.AccountUser;
import com.example.dncinema.model.Roles;
import com.example.dncinema.security.jwt.JwtProvider;
import com.example.dncinema.security.request.SignInForm;
import com.example.dncinema.security.request.SignUpForm;
import com.example.dncinema.security.response.ErrorMessage;
import com.example.dncinema.security.response.JwtResponse;
import com.example.dncinema.security.response.ResponseMessage;
import com.example.dncinema.security.userPrincipal.UserPrinciple;
import com.example.dncinema.service.accountUser.IAccountUserService;
import com.example.dncinema.service.roles.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ChinhLV
 * @body signInForm
 * @return ResponseEntity<?> signup(@Valid @RequestBody SignUpForm signUpForm)
 * Phương thức sử dụng để đăng ký account dựa trên đầu vào là username và password
 * Kết quả trả về là 1 object bao gồm: message thành công khi lưu thành công hoặc bại khi lưu thất bại
 * @body signInForm
 * @return ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm)
 * Phương thức sử dụng để đăng nhập dựa trên đầu vào là username và password
 * Kết quả trả về là 1 object bao gồm: token được tạo có hiệu lực 1h, tên người dùng và quyền truy cập
 */
@RestController
@RequestMapping("/api/public")
@CrossOrigin("*")
public class SecurityController {
    @Autowired
    IAccountUserService accountUserService;
    @Autowired
    IRolesService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpForm signUpForm) {
        if (accountUserService.existByNameAccount(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("The username existed !!, Try again"), HttpStatus.OK);
        }
        AccountUser users = new AccountUser(signUpForm.getUsername(), passwordEncoder.encode(signUpForm.getPassword()));
        Set<String> strRoles = signUpForm.getRoles();
        Set<Roles> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Roles adminRole = roleService.findRolesByName("ADMIN");
                    roles.add(adminRole);
                    break;
                case "employee":
                    Roles employeeRole = roleService.findRolesByName("EMPLOYEE");
                    roles.add(employeeRole);
                    break;
                default:
                    Roles userRole = roleService.findRolesByName("USER");
                    roles.add(userRole);
            }
        });
        users.setRoles(roles);
        AccountUser accountUser = accountUserService.saveAccountUser(users);
        if (accountUser != null) {
            return new ResponseEntity<>(new ResponseMessage("Create user success!!!"), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ResponseMessage("Create user failed!!!"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ErrorMessage> errorMessages = new ArrayList<>();
            bindingResult
                    .getFieldErrors()
                    .stream()
                    .forEach(f -> errorMessages.add(new ErrorMessage(f.getField(), f.getDefaultMessage())));
            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getUsername(), userPrinciple.getAuthorities()));
    }
}
