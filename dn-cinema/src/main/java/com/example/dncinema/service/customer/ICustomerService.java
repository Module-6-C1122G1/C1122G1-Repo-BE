package com.example.dncinema.service.customer;

import com.example.dncinema.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> findAllCustomerTicket(Pageable pageable);

    Page<Customer> findAllCustomerPointHistory(Pageable pageable);
}
