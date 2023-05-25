package com.example.dncinema.service.customer.impl;

import com.example.dncinema.model.Customer;
import com.example.dncinema.repository.ICustomerRepository;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

//    @Override
//    public Page<Customer> findAllCustomerTicket(Pageable pageable) {
//        return iCustomerRepository.findAllCustomerTicket(pageable);
//    }
//
//    @Override
//    public Page<Customer> findAllCustomerPointHistory(Pageable pageable) {
//        return iCustomerRepository.findAllCustomerPointHistory(pageable);
//    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAllCustomer();
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.getById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void saveCustomer(String idCustomer, String nameCustomer, String gender, String address, String email, String identityCard, String phone, double pointCustomer, Integer typeCustomer) {
        iCustomerRepository.saveCustomer(idCustomer, nameCustomer, gender, address, email, phone, pointCustomer, typeCustomer, identityCard);
    }

    @Override
    public void updateCustomer(String idCustomer, String nameCustomer, String gender, String address, String email,
                               String identityCard, String phone, double pointCustomer, Integer typeCustomer, Integer id) {
        iCustomerRepository.updateCustomer(idCustomer, nameCustomer, gender, address, email,
                identityCard, pointCustomer, typeCustomer, phone, id);
    }
}
