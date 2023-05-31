package com.example.dncinema.repository;

import com.example.dncinema.model.Roles;
import com.example.dncinema.model.TypeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<TypeCustomer, Integer> {
    @Query(value = "select * from type_customer", nativeQuery = true)
    List<TypeCustomer> findAllCustomerType();

    TypeCustomer findByNameTypeCustomer(String name);
}
