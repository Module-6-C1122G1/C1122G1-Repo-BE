package com.example.dncinema.controller;

import com.example.dncinema.dto.TicketDTO;
import com.example.dncinema.model.Customer;
import com.example.dncinema.model.Discount;
import com.example.dncinema.model.Seat;
import com.example.dncinema.repository.ICustomerRepository;
import com.example.dncinema.repository.IDiscountRepositoryMinh;
import com.example.dncinema.repository.ISeatRepositoryMinh;
import com.example.dncinema.service.ITicketServiceMinh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/ticket/")
public class TicketControllerMinh {
    @Autowired
    private ITicketServiceMinh iTicketServiceMinh;
    @Autowired
    private ISeatRepositoryMinh iSeatRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @GetMapping("/check-discount")
    public ResponseEntity<Discount> checkDiscount(@RequestParam(name = "discount") String discount) {
        Discount discount1 = iTicketServiceMinh.findDiscount(discount);
        if (discount1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discount1, HttpStatus.OK);
    }

    @GetMapping("/get-customer")
    public ResponseEntity<Customer> getCustomer(@RequestParam(name = "username") String useName) {
        return new ResponseEntity<>(iCustomerRepository.findByAccountUser_NameAccount(useName), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<?> saveTicket(
            @RequestParam(name = "idCus") String idCus,
            @RequestParam(name = "idFilm") String idFilm,
            @RequestParam(name = "idDiscount") String codeDiscount,
            @RequestParam(name = "price") String price,
            @RequestParam(name = "seat") String seat,
            @RequestParam(name = "vnp_ResponseCode") String vnp_ResponseCode

    ) throws UnsupportedEncodingException {

        if (idCus == null || idFilm == null || price == null || seat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (vnp_ResponseCode.equals("00")) {
            String[] list = seat.split("");
            Integer[] listSeat = new Integer[list.length];
            for (int i = 0; i < list.length; i++) {
                listSeat[i] = Integer.parseInt(list[i]);
            }
            TicketDTO ticketDTO = new TicketDTO(Integer.parseInt(idCus), Integer.parseInt(idFilm), listSeat, Integer.parseInt(codeDiscount), Long.parseLong(price));
            iTicketServiceMinh.saveTicket(ticketDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("pay")
    public ResponseEntity<?> pay(@RequestBody TicketDTO ticketDTO) throws UnsupportedEncodingException {
        String url = iTicketServiceMinh.pay(ticketDTO);
        return new ResponseEntity<>(url, HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable(name = "id") Integer id) {
        Seat seat = iSeatRepository.getByIdSeat(id);
        if (seat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }
}