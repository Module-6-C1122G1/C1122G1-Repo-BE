package com.example.dncinema.service.ticket;

import com.example.dncinema.dto.TicketDetailDTO;
import com.example.dncinema.dto.TicketUpdateDTO;
import com.example.dncinema.model.Ticket;

import java.util.List;

public interface ITicketService {
    Ticket findTicketById(Integer id);

    void update(TicketUpdateDTO ticketUpdateDTO);
    List<TicketDetailDTO> findAll();

}
