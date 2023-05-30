package com.example.dncinema.service.employee;


import com.example.dncinema.dto.EmployeeDTO;
import com.example.dncinema.model.Employee;
import com.example.dncinema.service.employee.impl.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IEmployeeService {

    Page<EmployeeDTO> searchEmployee(Pageable pageable, String searchCode, String searchName, String searchPhoneNumber);

    void deleteEmployee(Integer id);

    Employee findByEmployeeId(Integer id);
}
