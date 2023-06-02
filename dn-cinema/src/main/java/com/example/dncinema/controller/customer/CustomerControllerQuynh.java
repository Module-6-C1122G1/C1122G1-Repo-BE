package com.example.dncinema.controller.customer;

import com.example.dncinema.model.Customer;
import com.example.dncinema.model.Ticket;
import com.example.dncinema.service.customer.ICustomerService;
import com.example.dncinema.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerControllerQuynh {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ITicketService iTicketService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detailCustomer(@PathVariable Integer id){
       Ticket ticket = iTicketService.findTicketById(id);
       Customer customer = iCustomerService.findById(ticket.getCustomer().getIdCustomer());
       return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
