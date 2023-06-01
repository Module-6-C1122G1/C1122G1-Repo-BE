package com.example.dncinema.service.employee;

import com.example.dncinema.dto.EmployeeDTO;
import com.example.dncinema.model.Employee;

import java.util.List;

public interface IEmployeeService {
    /**
     * Created by: NghiaTT
     * Date created: 24/05/2023
     * function: Update employee
     *
     * @param employeeDTO
     * @param id
     */
    void updateEmployee(EmployeeDTO employeeDTO, Integer id);

    List<Employee> findAll();

    /**
     * Created by: NghiaTT
     * Date created: 24/05/2023
     * function: Create employee
     *
     * @param employeeDTO
     */
    void create(EmployeeDTO employeeDTO);

    /**
     * Created by: NghiaTT
     * Date created: 24/05/2023
     * function: Find employee by id
     *
     * @param id
     * @return
     */
    Employee findById(int id);
}
