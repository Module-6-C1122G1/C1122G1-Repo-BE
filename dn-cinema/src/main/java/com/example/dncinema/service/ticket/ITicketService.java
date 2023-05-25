package com.example.dncinema.service.ticket;

import com.example.dncinema.dto.ListTicketDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketService {
    Page<ListTicketDTO> findAllTicket(String search, Pageable pageable);
    void cancelTicket(Integer id);
}
