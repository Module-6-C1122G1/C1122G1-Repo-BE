package com.example.dncinema.repository;

import com.example.dncinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "select * from ticket " +
            "inner join seat s on ticket.id_seat = s.id_seat" +
            " inner join show_time st on s.id_seat = st.id_seat " +
            "inner join film f on st.id_show_time = f.id_show_time " +
            "inner join customer c on ticket.id_customer = c.id_customer" +
            " inner join employee e on ticket.id_employee = e.id_employee " +
            "inner join discount d on ticket.id_discount = d.id_discount" +
            " where id_ticket=:id", nativeQuery = true)
    Ticket findTicketById(@Param("id") Integer id);
}
