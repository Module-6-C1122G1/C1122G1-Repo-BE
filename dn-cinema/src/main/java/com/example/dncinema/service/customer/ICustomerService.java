package com.example.dncinema.service.customer;

import com.example.dncinema.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface ICustomerService {

    Page<Customer> findAllCustomerTicket(Pageable pageable);

    Page<Customer> findAllCustomerPointHistory(Pageable pageable);

    Page<Customer> searchPlusPoint(Pageable pageable , LocalDate dateStart,LocalDate dateEnd);

    Page<Customer> searchUsePoint(Pageable pageable , LocalDate dateStart , LocalDate dateEnd);
}
