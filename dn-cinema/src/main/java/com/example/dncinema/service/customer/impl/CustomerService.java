package com.example.dncinema.service.customer.impl;

import com.example.dncinema.dto.customerDTO.CustomerDTO;
import com.example.dncinema.model.AccountUser;
import com.example.dncinema.model.Customer;
import com.example.dncinema.repository.IAccountRepository;
import com.example.dncinema.repository.ICustomerRepository;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Autowired
    private IAccountRepository iAccountRepository;


    @Override
    public Page<Customer> findAllCustomerTicket(Pageable pageable) {
        return iCustomerRepository.findAllCustomerTicket(pageable);
    }

    @Override
    public Page<Customer> findAllCustomerPointHistory(Pageable pageable) {
        return iCustomerRepository.findAllCustomerPointHistory(pageable);
    }

    @Override
    public Page<Customer> searchPlusPoint(Pageable pageable, LocalDate dateStart, LocalDate dateEnd) {
        return iCustomerRepository.findAllPlusPoint(pageable,dateStart,dateEnd);
    }

    @Override
    public Page<Customer> searchUsePoint(Pageable pageable, LocalDate dateStart, LocalDate dateEnd) {
        return iCustomerRepository.findAllUsePoint(pageable,dateStart,dateEnd);
    }

    /**
     * Created by: TruongNN
     * Date created: 24/05/2023
     * function: create customer
     *
     * @param customerDTO
     */
    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        iAccountRepository.createAccountUser(customerDTO.getAccountUser().getNameAccount(),
                customerDTO.getAccountUser().getPasswordAccount());
        AccountUser accountUser = iAccountRepository
                .findAccountUserByNameAccount(customerDTO.getAccountUser().getNameAccount());
        Customer customer = new Customer();
        customer.setAccountUser(accountUser);
        BeanUtils.copyProperties(customerDTO, customer);
        iCustomerRepository.saveCustomer(
                customer.getNameCustomer(),
                customer.getPointCustomer(),
                customer.getGender(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getIdentityCard(),
                customer.getTypeCustomer().getIdTypeCustomer(),
                accountUser.getId()
        );
    }
    /**
     * Created by: TruongNN
     * Date created: 24/05/2023
     * function: Update customer
     *
     * @param customerDTO
     * @param id
     */
    @Override
    public void updateRegisterCustomer(CustomerDTO customerDTO, Integer id) {
        AccountUser accountUser = iAccountRepository
                .findAccountUserByNameAccount(customerDTO.getAccountUser().getNameAccount());

        iAccountRepository.updateAccount(customerDTO.getAccountUser().getNameAccount(), customerDTO.getAccountUser().getPasswordAccount(),
                accountUser.getId());
        Customer customer = iCustomerRepository.findByIdCustomer(id);
        BeanUtils.copyProperties(customerDTO, customer);
        iCustomerRepository.updateCustomerAccount(
                customerDTO.getNameCustomer(),
                customerDTO.getPointCustomer(),
                customerDTO.getGender(),
                customerDTO.getPhone(),
                customerDTO.getAddress(),
                customerDTO.getEmail(),
                customerDTO.getIdentityCard(),
                customerDTO.getTypeCustomer().getIdTypeCustomer(),
                accountUser.getId(),
                customerDTO.getIdCustomer()
        );
    }

    /**
     * Created by: TruongNN
     * Date created: 24/05/2023
     * function: Find customer by id
     *
     * @param id
     * @return
     */
    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findByIdCustomer(id);
    }
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
