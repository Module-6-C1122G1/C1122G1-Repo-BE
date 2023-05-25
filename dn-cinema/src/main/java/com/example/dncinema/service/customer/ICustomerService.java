package com.example.dncinema.service.customer;

import com.example.dncinema.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save (Customer customer);

    void saveCustomer(String idCustomer, String nameCustomer, String gender, String address, String email,
             String identityCard,String phone, double pointCustomer,Integer typeCustomer);

    void updateCustomer(String idCustomer, String nameCustomer, String gender, String address, String email,
                        String identityCard,String phone, double pointCustomer,Integer typeCustomer, Integer id);

}
