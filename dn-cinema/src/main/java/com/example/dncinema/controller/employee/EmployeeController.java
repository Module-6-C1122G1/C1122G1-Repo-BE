package com.example.dncinema.controller.employee;

import com.example.dncinema.dto.EmployeeDTO;
import com.example.dncinema.model.Employee;
import com.example.dncinema.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @PatchMapping("/create")
    public void createEmployeeWithAccount(@RequestBody EmployeeDTO employeeDTO) {
        iEmployeeService.create(employeeDTO, employeeDTO.getAccountUser().getNameAccount(), employeeDTO.getAccountUser().getPasswordAccount());
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update")
    public void updateEmployeeWithAccount(@RequestBody EmployeeDTO employeeDTO,
                                          @PathVariable("id") Integer id) {
        iEmployeeService.updateEmployee(employeeDTO, id);
    }
}
