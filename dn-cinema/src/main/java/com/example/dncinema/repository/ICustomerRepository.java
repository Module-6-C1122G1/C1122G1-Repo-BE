package com.example.dncinema.repository;

import com.example.dncinema.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select name_film, date_booking, status_ticket, price_after_discount from customer\n" +
            "join ticket on ticket.id_customer = customer.id_customer\n" +
            "join seat on ticket.id_seat = seat.id_seat\n" +
            "join show_time on show_time.id_seat = seat.id_seat\n" +
            "join film on film.id_show_time = show_time.id_show_time",nativeQuery = true)
    Page<Customer> findAllCustomerTicket(Pageable pageable);

    @Query(value = "select date_booking , name_film , point_customer from customer\n" +
            "join ticket on ticket.id_customer = customer.id_customer\n" +
            "join seat on ticket.id_seat = seat.id_seat\n" +
            "join show_time on show_time.id_seat = seat.id_seat\n" +
            "join film on film.id_show_time = show_time.id_show_time" , nativeQuery = true)
    Page<Customer> findAllCustomerPointHistory(Pageable pageable);

    @Query(value = "select * from ticket where date_booking between '2023-01-01' and '2023-12-30'" , nativeQuery = true)
    Page<Customer> findAllPlusPoint(Pageable pageable , LocalDate startDate , LocalDate dateEnd);

    @Query(value = "select * from ticket where date_booking between '2023-01-01' and '2023-12-30'" , nativeQuery = true)
    Page<Customer> findAllUsePoint (Pageable pageable , LocalDate startDate , LocalDate dateEnd);
}
