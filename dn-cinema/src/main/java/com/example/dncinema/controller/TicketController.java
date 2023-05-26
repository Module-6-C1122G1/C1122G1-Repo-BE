
package com.example.dncinema.controller;

import com.example.dncinema.model.Ticket;
import com.example.dncinema.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @Param id
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> findTicketById(@PathVariable Integer id) {
        Ticket ticket=iTicketService.findTicketById(id);
        if(ticket==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
}

