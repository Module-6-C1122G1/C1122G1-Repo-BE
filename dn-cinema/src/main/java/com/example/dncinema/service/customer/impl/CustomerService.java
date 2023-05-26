package com.example.dncinema.service.customer.impl;

import com.example.dncinema.dto.CustomerDTO;
import com.example.dncinema.model.Customer;
import com.example.dncinema.repository.ICustomerRepository;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.searchCustomerInfo(pageable);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO, Integer id) {
//        Customer customer = iCustomerRepository.findByIdCustomer(id);
//        BeanUtils.copyProperties(customerDTO, customer);
//        iCustomerRepository.updateCustomer(
//                customerDTO.getNameCustomer()
//                , customer.getGender()
//                , customer.getAddress()
//                , customer.getEmail()
//                , customer.getPointCustomer()
//                , customer.getPhone()
//                , customer.getTypeCustomer()
//                , customer.getIdentityCard()
//                , customer.getIdCustomer()
//                , customer.getAccountUser()
//        );
    }


    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findByIdCustomer(id);
    }


}
