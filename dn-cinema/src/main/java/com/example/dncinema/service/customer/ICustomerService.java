package com.example.dncinema.service.customer;

import com.example.dncinema.dto.customerDTO.CustomerDTO;
import com.example.dncinema.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> findAllCustomerTicket(Pageable pageable);

    Page<Customer> findAllCustomerPointHistory(Pageable pageable);

    void createCustomer(CustomerDTO customerDTO, String userName, String password);
    void updateRegisterCustomer(CustomerDTO customerDTO, Integer id);
    Customer findById(int id);

    List<Customer> findAll();
}
