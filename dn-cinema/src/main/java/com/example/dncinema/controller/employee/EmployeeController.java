
package com.example.dncinema.controller.employee;

import com.example.dncinema.dto.EmployeeDTO;
import com.example.dncinema.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/employee")
@CrossOrigin("*")
public class EmployeeController {
//    @Autowired
//    private IEmployeeService iEmployeeService;


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
}