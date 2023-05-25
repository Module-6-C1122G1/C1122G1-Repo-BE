package com.example.dncinema.controller;

import com.example.dncinema.model.Film;
import com.example.dncinema.model.Ticket;
import com.example.dncinema.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {
    @Autowired
    ITicketService iTicketService;

    /**
     * Create: QuynhHTN
     * Date create: 24/05/2023
     * @param idTicket
     * @return
     */
    @GetMapping("/detail/{idTicket}")
    public ResponseStatus<?> findTicketById(@PathVariable Integer idTicket) {
        Ticket ticket=iTicketService.findTicketById(idTicket);
        if(ticket==null){
            return new ResponseStatus<>(HttpStatus.BAD_REQUEST);
        }return new ResponseStatus<>(ticket,HttpStatus.OK);
    }
}
