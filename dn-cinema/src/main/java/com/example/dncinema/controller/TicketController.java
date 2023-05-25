package com.example.dncinema.controller;

import com.example.dncinema.model.Ticket;
import com.example.dncinema.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    /**
     * @param pageable
     * @param search
     * @return ResponseEntity<>(tickets, HttpStatus.OK;
     * Phương thức sử dụng để tìm kiếm kết hợp danh sách vé đặt
     * @author DatLVP
     */

    @GetMapping("")
    public ResponseEntity<?> findAllTicket(@PageableDefault Pageable pageable,
                                           @RequestParam(required = false, defaultValue = "") String search) {
        Page<Ticket> tickets = ticketService.findAllTicket(search, pageable);
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(tickets, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    /**
     * @param id
     * @return HttpStatus.OK;
     * Phương thức sử dụng để id để huỷ vé
     * @author DatLVP
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Integer id) {
        ticketService.cancelTicket(id);
    }
}
