package com.example.dncinema.controller.employee;

import com.example.dncinema.dto.EmployeeDTO;
import com.example.dncinema.model.Employee;
import com.example.dncinema.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Employee> findAll() {
        return iEmployeeService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public ResponseEntity<?> createEmployeeWithAccount(@Valid @RequestBody EmployeeDTO employeeDTO , BindingResult bindingResult) {
       if (bindingResult.hasErrors()){
           return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
       }
        iEmployeeService.create(employeeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updateEmployeeWithAccount(@RequestBody EmployeeDTO employeeDTO,
                                          @PathVariable("id") Integer id) {
        iEmployeeService.updateEmployee(employeeDTO, id);
    }
}
