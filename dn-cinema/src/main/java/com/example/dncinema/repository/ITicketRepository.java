package com.example.dncinema.repository;

import com.example.dncinema.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "select distinct ticket.id_ticket, customer.id_customer, customer.name_customer, customer.phone, " +
            "customer.identity_card, film.name_film, show_time.show_date, show_time.show_time " +
            "form ticket " +
            "join customer on ticket.id_customer = customer.id_customer " +
            "join seat on ticket.id_seat = seat.id_seat " +
            "join show_time on seat.id_seat = show_time.id_seat " +
            "join film on show_time.id_show_time = film.id_show_time " +
            "where customer.name_customer like concat('%', :search, '%') " +
            "or customer.phone like concat('%', :search, '%') " +
            "or customer.identity_card like concat('%', :search, '%') " +
            "or film.name_film like concat('%', :search, '%') ", nativeQuery = true)
    Page<Ticket> findAllTicket(@Param("search") String search, Pageable pageable);
}
