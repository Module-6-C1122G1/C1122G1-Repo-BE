package com.example.dncinema.service.ticket.impl;

import com.example.dncinema.dto.ListTicketDTO;
import com.example.dncinema.repository.ITicketRepository;
import com.example.dncinema.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;

    @Override
    public Page<ListTicketDTO> findAllTicket(String search, Pageable pageable) {
        return ticketRepository.find_list_ticket(search, pageable);
    }

    @Override
    public void cancelTicket(Integer id) {
        ticketRepository.cancelTicket(id);
    }
}
