//package com.example.dncinema.controller;
//
//import com.example.dncinema.dto.TicketDTO;
//import com.example.dncinema.model.Discount;
//import com.example.dncinema.service.ITicketServiceMinh;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.UnsupportedEncodingException;
//
//@RestController
//@RequestMapping("/api/ticket/")
//public class TicketControllerMinh {
//    @Autowired
//    ITicketServiceMinh iTicketServiceMinh;
//
//    @GetMapping(name = "/discount")
//    public ResponseEntity<Discount> checkDiscount(@RequestParam String discount) {
//        Discount discount1 = iTicketServiceMinh.findDiscount(discount);
//        if (discount1 == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(discount1, HttpStatus.OK);
//    }
//    @PostMapping("/create")
//    public ResponseEntity<?> saveTicket(@RequestBody TicketDTO ticketDTO) throws UnsupportedEncodingException {
//        iTicketServiceMinh.saveTicket(ticketDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//}
