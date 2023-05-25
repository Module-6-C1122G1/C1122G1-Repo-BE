package com.example.dncinema.service.ticket.impl;

import com.example.dncinema.model.Ticket;
import com.example.dncinema.repository.ITicketRepository;
import com.example.dncinema.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository iTicketRepository;

    @Override
    public Ticket findTicketById(Integer id) {
        return iTicketRepository.findTicketById(id);
    }


}
