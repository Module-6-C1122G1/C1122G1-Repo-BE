package com.example.dncinema.service.ticket;

import com.example.dncinema.model.Ticket;

public interface ITicketService {
    Ticket findTicketById(Integer idTicket);
}
