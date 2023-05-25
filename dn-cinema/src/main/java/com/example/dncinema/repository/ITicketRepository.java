package com.example.dncinema.repository;

import com.example.dncinema.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "select distinct ticket.id_ticket, customer.id_customer, customer.name_customer, customer.phone, \n" +
            "   customer.identity_card, film.name_film, show_time.show_date, show_time.show_time \n" +
            "   from ticket\n" +
            "   join customer on ticket.id_customer = customer.id_customer\n" +
            "   join seat on ticket.id_seat = seat.id_seat\n" +
            "   join show_time on seat.id_seat = show_time.id_seat\n" +
            "   join film on show_time.id_show_time = film.id_show_time\n" +
            "   where customer.name_customer like concat('%', :search, '%')\n" +
            "   or customer.phone like concat('%', :search, '%')\n" +
            "   or customer.identity_card like concat('%', :search, '%')\n" +
            "   or film.name_film like concat('%', :search, '%')"
            , nativeQuery = true)
    Page<Ticket> findAllTicket(@Param("search") String search, Pageable pageable);
    @Modifying
    @Transactional
    @Query(value = "delete from ticket where id_ticket = :id", nativeQuery = true)
    void cancelTicket(@Param("id") Integer id);

}
