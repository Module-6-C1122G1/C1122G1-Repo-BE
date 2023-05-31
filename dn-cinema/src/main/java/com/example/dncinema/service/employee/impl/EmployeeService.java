package com.example.dncinema.service.employee.impl;

import com.example.dncinema.dto.EmployeeDTO;
import com.example.dncinema.model.AccountUser;
import com.example.dncinema.model.Employee;
import com.example.dncinema.repository.IAccountUserRepository;
import com.example.dncinema.repository.IEmployeeRepository;
import com.example.dncinema.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Autowired
    private IAccountUserRepository iAccountUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Created by: NghiaTT
     * Date created: 24/05/2023
     * function: Update employee
     *
     * @param employeeDTO
     * @param id
     */
    @Override
    public void updateEmployee(EmployeeDTO employeeDTO, Integer id) {
        AccountUser accountUser = iAccountUserRepository
                .findAccountUserByNameAccount(employeeDTO.getAccountUser().getNameAccount());
        iAccountUserRepository.updateAccount(employeeDTO.getAccountUser().getNameAccount(), passwordEncoder.encode(employeeDTO.getAccountUser().getPasswordAccount()), accountUser.getId());
        Employee employee = iEmployeeRepository.findByIdEmployee(id);
        BeanUtils.copyProperties(employeeDTO, employee);
        iEmployeeRepository.updateEmployeeWithAccount(employeeDTO.getNameEmployee()
                , employee.getPhone()
                , employee.getAddress()
                , employee.getGender()
                , employee.getDateOfBirth()
                , employee.getImgEmployee()
                , employee.getEmail()
                , employee.getIdentityCard()
                , accountUser.getId()
                , employee.getIdEmployee());
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    /**
     * Created by: NghiaTT
     * Date created: 24/05/2023
     * function: Create employee
     *
     * @param employeeDTO
     */
    @Override
    public void create(EmployeeDTO employeeDTO) {
        iAccountUserRepository.createAccountUser(employeeDTO.getAccountUser().getNameAccount(),
                passwordEncoder.encode(employeeDTO.getAccountUser().getPasswordAccount()));
        AccountUser accountUser = iAccountUserRepository
                .findAccountUserByNameAccount(employeeDTO.getAccountUser().getNameAccount());
        Employee employee = new Employee();
        employee.setAccountUser(accountUser);
        BeanUtils.copyProperties(employeeDTO, employee);
        iEmployeeRepository.saveEmployee(
                employee.getNameEmployee(),
                employee.getPhone(),
                employee.getAddress(),
                employee.getGender(),
                employee.getDateOfBirth(),
                employee.getImgEmployee(),
                employee.getEmail(),
                employee.getIdentityCard(),
                accountUser.getId()
        );
    }

    /**
     * Created by: NghiaTT
     * Date created: 24/05/2023
     * function: Find employee by id
     *
     * @param id
     * @return
     */
    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findByIdEmployee(id);
    }

}
