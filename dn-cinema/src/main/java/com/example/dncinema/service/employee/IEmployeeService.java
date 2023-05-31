package com.example.dncinema.service.employee;


import com.example.dncinema.dto.EmployeeDTO;
import com.example.dncinema.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<EmployeeDTO> searchEmployee(Pageable pageable, String search);

    void deleteEmployee(Integer id);

    Employee findByEmployeeId(Integer id);
}
