package com.example.dncinema.service.customer;

import com.example.dncinema.dto.CustomerDTO;
import com.example.dncinema.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void updateCustomer(CustomerDTO customerDTO, Integer id);

    Customer findById(int id);
}
