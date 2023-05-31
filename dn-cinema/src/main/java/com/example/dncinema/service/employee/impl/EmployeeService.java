package com.example.dncinema.service.employee.impl;

import com.example.dncinema.dto.EmployeeDTO;
import com.example.dncinema.model.AccountUser;
import com.example.dncinema.model.Employee;
import com.example.dncinema.repository.IEmployeeRepository;
import com.example.dncinema.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    @Override
    public Page<EmployeeDTO> searchEmployee(Pageable pageable, String search) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        Page<Employee> employeePage = iEmployeeRepository
                .searchEmployeeInfo(pageable,search);
        EmployeeDTO employeeDTO;
        for (Employee employee : employeePage) {
            employeeDTO = new EmployeeDTO();
            employeeDTO.setAccountUser(new AccountUser());
            BeanUtils.copyProperties(employee.getAccountUser(), employeeDTO.getAccountUser());
            BeanUtils.copyProperties(employee, employeeDTO);
            employeeDTOList.add(employeeDTO);
        }
        return new PageImpl<>(employeeDTOList, pageable, employeePage.getTotalElements());
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = iEmployeeRepository.findByEmployeeId(id);
        employee.setDelete(true);
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findByEmployeeId(Integer id) {
        return iEmployeeRepository.findByEmployeeId(id);
    }
}
