//package com.example.dncinema.controller.employee;
//
//import com.example.dncinema.dto.EmployeeDTO;
//import com.example.dncinema.service.employee.IEmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("api/employee")
//@CrossOrigin("*")
//public class EmployeeController {
//    @Autowired
//    private IEmployeeService iEmployeeService;
//
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("")
//    public ResponseEntity<Page<EmployeeDTO>> search(@PageableDefault(sort = {"id"},direction = Sort.Direction.DESC, size = 5) Pageable pageable,
//                                                    @RequestParam(required = false) String searchCode,
//                                                    @RequestParam(required = false)  String searchName,
//                                                    @RequestParam(required = false) String searchPhoneNumber) {
//
//        Page<EmployeeDTO> employeeDTOS = this.iEmployeeService.searchEmployee(pageable, searchCode, searchName, searchPhoneNumber);
//
//        if (employeeDTOS.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
//    }
//
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteEmployee(@PathVariable Integer id) {
//        iEmployeeService.deleteEmployee(id);
//    }
//
//}
