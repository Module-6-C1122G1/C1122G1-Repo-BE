package com.example.dncinema.repository.employee;

import com.example.dncinema.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee , Integer> {

}
