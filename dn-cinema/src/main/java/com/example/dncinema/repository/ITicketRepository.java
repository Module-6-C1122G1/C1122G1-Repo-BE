package com.example.dncinema.repository;

import com.example.dncinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {

}
