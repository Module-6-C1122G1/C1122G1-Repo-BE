package com.example.dncinema.repository;

import com.example.dncinema.dto.ICustomerPoint;
import com.example.dncinema.dto.ITicketManagement;
import com.example.dncinema.model.Customer;
import com.example.dncinema.model.Ticket;
import com.example.dncinema.model.TicketManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ITicketManagementRepository extends JpaRepository<TicketManagement, Integer> {
    @Query(value = "select film.name_film as nameFilm, ticket.id_ticket as idTicket,ticket.date_booking as dateBooking , ticket.price_after_discount as priceAfterDiscount, ticket.status_ticket as statusTicket from customer join " +
            "ticket on ticket.id_customer = customer.id_customer join" +
            " seat on ticket.id_seat = seat.id_seat join " +
            "show_time on show_time.id_seat = seat.id_seat join" +
            " film on film.id_show_time = show_time.id_show_time",
            countQuery = "select count(*) from customer " +
                    "join ticket on ticket.id_customer = customer.id_customer " +
                    "join seat on ticket.id_seat = seat.id_seat " +
                    "join show_time on show_time.id_seat = seat.id_seat " +
                    "join film on film.id_show_time = show_time.id_show_time",
            nativeQuery = true)
    Page<ITicketManagement> findCustomerByTicket(Pageable pageable);

    @Query(value = "select ticket.date_booking as dateBooking, film.name_film as nameFilm, customer.point_customer as pointCustomer from customer " +
            "join ticket on ticket.id_customer = customer.id_customer " +
            "join seat on ticket.id_seat = seat.id_seat " +
            "join show_time on show_time.id_seat = seat.id_seat " +
            "join film on film.id_show_time = show_time.id_show_time",
            countQuery = "select count(*) from customer " +
                    "join ticket on ticket.id_customer = customer.id_customer " +
                    "join seat on ticket.id_seat = seat.id_seat " +
                    "join show_time on show_time.id_seat = seat.id_seat " +
                    "join film on film.id_show_time = show_time.id_show_time",
            nativeQuery = true)
    Page<ICustomerPoint> findAllCustomerPointHistory(Pageable pageable);

    @Query(value = "select * from ticket where date_booking between '2023-01-01' and '2023-12-30'", nativeQuery = true)
    Page<TicketManagement> findAllPlusPoint(Pageable pageable, LocalDate startDate, LocalDate dateEnd);

    @Query(value = "select * from ticket where date_booking between '2023-01-01' and '2023-12-30'", nativeQuery = true)
    Page<TicketManagement> findAllUsePoint(Pageable pageable, LocalDate startDate, LocalDate dateEnd);

}
