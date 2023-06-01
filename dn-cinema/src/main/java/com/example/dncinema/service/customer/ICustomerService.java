package com.example.dncinema.service.customer;

import com.example.dncinema.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllAndSearch(String nameSearch);


    void updateCustomer(
            String nameCustomer,
            String phone,
            String address,
            String email,
            Integer idCustomer,
            String identityCard);

    Customer findById(int id);
}
