package com.example.dncinema.repository;

import com.example.dncinema.model.Customer;
import com.example.dncinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where id_customer= :id",nativeQuery = true)
    List<Customer> getByIdCus(@Param("id") Integer id);
}
