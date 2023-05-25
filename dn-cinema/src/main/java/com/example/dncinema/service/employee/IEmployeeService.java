package com.example.dncinema.service.employee;

import com.example.dncinema.dto.EmployeeDTO;
import com.example.dncinema.model.Employee;

import java.util.List;

public interface IEmployeeService {
    void updateEmployee(Employee employee, int id);

    List<Employee> findAll();

    void create(EmployeeDTO employeeDTO , String userName, String password);
}
