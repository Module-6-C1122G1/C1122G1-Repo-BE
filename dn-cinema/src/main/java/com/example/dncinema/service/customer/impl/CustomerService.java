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
    private ICustomerRepository iCustomerRepository;


    @Override
    public List<Customer> findAllAndSearch(String nameSearch) {
        return iCustomerRepository.findAllAndSearch(nameSearch);
    }

    @Override
    public void updateCustomer(String nameCustomer, String phone, String address, String email, Integer idCustomer, String identityCard) {
        iCustomerRepository.updateCustomer(nameCustomer, phone, address, email, idCustomer, identityCard);
    }


    /**
     * @author ThanhNV
     * @param id
     * @return iCustomerRepository.findByIdCustomer(id);
     */
    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findByIdCustomer(id);
    }


}
