package com.example.dncinema.service.employee.impl;

import com.example.dncinema.dto.EmployeeDTO;
import com.example.dncinema.model.AccountUser;
import com.example.dncinema.model.Employee;
import com.example.dncinema.repository.IEmployeeRepository;
import com.example.dncinema.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public void updateEmployee(Employee employee, int id) {

    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void create(EmployeeDTO employeeDTO, String userName, String password) {
        AccountUser accountUser = new AccountUser();
        accountUser.setNameAccount(userName);
        accountUser.setPasswordAccount(password);
        Employee employee = new Employee();
        employee.setAccountUser(accountUser);
        BeanUtils.copyProperties(employeeDTO, employee);
        iEmployeeRepository.saveEmployee(
                employee.getNameEmployee(),
                employeeDTO.getPhone(),
                employeeDTO.getAddress(),
                employeeDTO.getGender(),
                employeeDTO.getImgEmployee(),
                employeeDTO.getEmail(),
                employeeDTO.getIdentityCard(),
                employee.getAccountUser().getId()
        );
    }

}
