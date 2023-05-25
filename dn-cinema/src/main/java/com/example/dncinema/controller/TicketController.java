package com.example.dncinema.controller;

import com.example.dncinema.model.Ticket;
import com.example.dncinema.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    /**
     * @param pageable
     * @param search
     * @return PageImpl<>(ticketList, pageable, tickets.getTotalElements());
     * Phương thức sử dụng để tìm kiếm kết hợp xổ danh sách vé đặt
     * @author DatLVP
     */

    @GetMapping("")
    @ResponseStatus()
    public Page<Ticket> findAllTicket(@PageableDefault(size = 7) Pageable pageable,
                                      @RequestParam(required = false, defaultValue = "") String search) {
        Page<Ticket> tickets = ticketService.findAllTicket(search, pageable);
        List<Ticket> ticketList = tickets.toList();
        return new PageImpl<>(ticketList, pageable, tickets.getTotalElements());
    }
}
