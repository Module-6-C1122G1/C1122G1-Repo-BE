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
    public void updateEmployee(EmployeeDTO employeeDTO, Integer id) {
        Employee employee = iEmployeeRepository.findByIdEmployee(id);
        BeanUtils.copyProperties(employeeDTO, employee);
        iEmployeeRepository.updateEmployeeWithAccount(employeeDTO.getNameEmployee()
                , employee.getPhone()
                , employeeDTO.getAddress()
                , employee.getGender()
                , employee.getImgEmployee()
                , employee.getEmail()
                , employee.getIdentityCard()
                , employee.getAccountUser().getId()
                , employee.getIdEmployee());
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
                employee.getPhone(),
                employee.getAddress(),
                employee.getGender(),
                employee.getImgEmployee(),
                employee.getEmail(),
                employee.getIdentityCard(),
                employee.getAccountUser().getId()
        );
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findByIdEmployee(id);
    }

}
