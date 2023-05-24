package com.example.dncinema.service.customer.impl;

import com.example.dncinema.model.Customer;
import com.example.dncinema.repository.ICustomerRepository;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.getById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
