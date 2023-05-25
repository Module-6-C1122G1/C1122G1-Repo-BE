package com.example.dncinema.service.customer.impl;

import com.example.dncinema.model.Customer;
import com.example.dncinema.repository.ICustomerRepository;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllCustomerTicket(Pageable pageable) {
        return iCustomerRepository.findAllCustomerTicket(pageable);
    }

    @Override
    public Page<Customer> findAllCustomerPointHistory(Pageable pageable) {
        return iCustomerRepository.findAllCustomerPointHistory(pageable);
    }
}
