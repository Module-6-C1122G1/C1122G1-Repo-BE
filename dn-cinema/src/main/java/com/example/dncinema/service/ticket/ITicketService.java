package com.example.dncinema.service.ticket;

import com.example.dncinema.dto.ListTicketDTO;
import com.example.dncinema.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITicketService {
    Ticket findTicketById(Integer id);

    void update(TicketUpdateDTO ticketUpdateDTO);
    List<TicketDetailDTO> findAll();

    Page<ListTicketDTO> findAllTicket(String search, Pageable pageable);

    void cancelTicket(Integer id);
}
