package com.example.dncinema.service.customer;

import com.example.dncinema.dto.CustomerDTO;
import com.example.dncinema.model.Customer;
import com.example.dncinema.model.TypeCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

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
