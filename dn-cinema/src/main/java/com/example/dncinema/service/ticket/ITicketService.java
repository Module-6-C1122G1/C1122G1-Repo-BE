package com.example.dncinema.service.ticket;

import com.example.dncinema.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketService {
    Page<Ticket> findAllTicket(String search, Pageable pageable);
    void cancelTicket(Integer id);
}
