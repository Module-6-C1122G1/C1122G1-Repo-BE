package com.example.dncinema.repository;

import com.example.dncinema.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * form customer", nativeQuery = true)
    List<Customer> findAllCustomer();

    @Query(value = "update customers\n" +
            "set id_customer = :id_customer, name_customer = :name_customer, gender = :gender , point = : point" +
            "phone = :phone, address = :address, email = :email, \n" +
            " total_amount = :total_amount, id_type_customer = :id_type_customer, identity_card = :identity_card" +
            "WHERE id = 1",
            nativeQuery = true)
    void updateCustomer(
            @Param("idCustomer") String idCustomer,
            @Param("nameCustomer") String nameCustomer,
            @Param("gender") String gender,
            @Param("address") String address,
            @Param("email") String email,
            @Param("phone") String phone,
            @Param("pointCustomer") double pointCustomer,
            @Param("typeCustomer") Integer typeCustomer,
            @Param("identityCard") String identityCard,
            @Param("id") Integer id
    );

    @Query(value = "insert into customers( id_customer, name_customer, gender, address, email, phone,total_amount, pointCustomer,id_type_customer) " +
            "value (:code, :name, :gender, :dateOfBirth, :address, :email, :phoneNumber, :point, false,:customerTypeId)",
            nativeQuery = true)
    void saveCustomer(
            @Param("idCustomer") String idCustomer,
            @Param("nameCustomer") String nameCustomer,
            @Param("gender") String gender,
            @Param("address") String address,
            @Param("email") String email,
            @Param("phone") String phone,
            @Param("pointCustomer") double pointCustomer,
            @Param("typeCustomer") Integer typeCustomer,
            @Param("identityCard") String identityCard)
            ;


    @Query(value = "select name_film, date_booking, status_ticket, price_after_discount from customer\n" +
            "join ticket on ticket.id_customer = customer.id_customer\n" +
            "join seat on ticket.id_seat = seat.id_seat\n" +
            "join show_time on show_time.id_seat = seat.id_seat\n" +
            "join film on film.id_show_time = show_time.id_show_time", nativeQuery = true)
    Page<Customer> findAllCustomerTicket(Pageable pageable);

    @Query(value = "select date_booking , name_film , point_customer from customer\n" +
            "join ticket on ticket.id_customer = customer.id_customer\n" +
            "join seat on ticket.id_seat = seat.id_seat\n" +
            "join show_time on show_time.id_seat = seat.id_seat\n" +
            "join film on film.id_show_time = show_time.id_show_time", nativeQuery = true)
    Page<Customer> findAllCustomerPointHistory(Pageable pageable);

}
