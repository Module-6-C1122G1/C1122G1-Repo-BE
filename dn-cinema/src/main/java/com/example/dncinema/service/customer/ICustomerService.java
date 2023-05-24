package com.example.dncinema.service.customer;

import com.example.dncinema.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save (Customer customer);
}
