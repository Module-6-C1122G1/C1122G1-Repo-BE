package com.example.dncinema.repository;

import com.example.dncinema.dto.StatisticsDTO;
import com.example.dncinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IStatisticsRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "select count(ticket.id_ticket) as totalticketssold,\n" +
            "\t\t   sum(ticket.price_after_discount) as totalrevenue,\n" +
            "\t\t   film.name_film as namefilm\n" +
            "\tfrom ticket\n" +
            "\tjoin seat on ticket.id_seat = seat.id_seat\n" +
            "\tjoin show_time on seat.id_show_room = show_time.id_show_room\n" +
            "\tjoin film on show_time.id_show_time = film.id_show_time\n" +
            "\tgroup by film.id_film", nativeQuery = true)
    StatisticsDTO findCommentSummaryByTitle();
}
