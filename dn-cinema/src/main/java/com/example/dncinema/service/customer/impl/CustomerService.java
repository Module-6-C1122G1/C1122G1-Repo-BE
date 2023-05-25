package com.example.dncinema.service.customer.impl;

import com.example.dncinema.dto.customerDTO.CustomerDTO;
import com.example.dncinema.model.AccountUser;
import com.example.dncinema.model.Customer;
import com.example.dncinema.repository.IAccountRepository;
import com.example.dncinema.repository.ICustomerRepository;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Autowired
    private IAccountRepository iAccountRepository;


    @Override
    public Page<Customer> findAllCustomerTicket(Pageable pageable) {
        return iCustomerRepository.findAllCustomerTicket(pageable);
    }

    @Override
    public Page<Customer> findAllCustomerPointHistory(Pageable pageable) {
        return iCustomerRepository.findAllCustomerPointHistory(pageable);
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO, String userName, String password) {
        AccountUser accountUser = new AccountUser();
        accountUser.setNameAccount(userName);
        accountUser.setPasswordAccount(password);
        iAccountRepository.save(accountUser);

        Customer customer = new Customer();
        customer.setAccountUser(accountUser);
        BeanUtils.copyProperties(customerDTO, customer);
        iCustomerRepository.saveCustomer(
                customer.getNameCustomer(),
                customer.getPointCustomer(),
                customer.getGender(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getIdentityCard(),
                customer.getTypeCustomer().getIdTypeCustomer(),
                customer.getAccountUser().getId()
        );
    }

    @Override
    public void updateRegisterCustomer(CustomerDTO customerDTO, Integer id) {
        Customer customer = iCustomerRepository.findByIdCustomer(id);
        BeanUtils.copyProperties(customerDTO, customer);
        iCustomerRepository.updateCustomerAccount(
                customerDTO.getNameCustomer(),
                customerDTO.getPointCustomer(),
                customerDTO.getGender(),
                customerDTO.getPhone(),
                customerDTO.getAddress(),
                customerDTO.getEmail(),
                customerDTO.getIdentityCard(),
                customerDTO.getTypeCustomer().getIdTypeCustomer(),
                customerDTO.getAccountUser().getId()
        );
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findByIdCustomer(id);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
