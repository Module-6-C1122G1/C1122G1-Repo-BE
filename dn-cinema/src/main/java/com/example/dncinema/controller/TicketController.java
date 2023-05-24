package com.example.dncinema.controller;

import com.example.dncinema.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param model
     * @return: detail
     */
    @GetMapping("/detail/{idTicket}")
    public String detailTicket(@PathVariable Integer idTicket, Model model) {
        model.addAttribute("ticket",iTicketService.findTicketById(idTicket));
        return "detail";
    }
}
