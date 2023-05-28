package com.example.dncinema.controller.customer;

import com.example.dncinema.model.Customer;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer/ticket")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    /**
     * @param pageable
     * @return list customer , status OK
     * @author DongPV
     */
    @GetMapping("")
    public ResponseEntity<?> findAllCustomerTicket(@PageableDefault(size = 3) Pageable pageable) {
        Page<Customer> customers = iCustomerService.findAllCustomerTicket(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    /**
     * @param pageable
     * @return list customer point history , status OK
     * @author DongPV
     */
    @GetMapping("/history")
    public ResponseEntity<?> findAllCustomerPointHistory(@PageableDefault(size = 3) Pageable pageable) {
        Page<Customer> customers = iCustomerService.findAllCustomerPointHistory(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    /**
     * @param pageable
     * @param dateStart
     * @param dateEnd
     * @return list plus point , status OK
     * @author DongPV
     */
    @GetMapping("/plus-point")
    public ResponseEntity<?> findAllPlusPoint(@PageableDefault(size = 3) Pageable pageable, LocalDate dateStart, LocalDate dateEnd) {
        Page<Customer> customers = iCustomerService.searchPlusPoint(pageable, dateStart, dateEnd);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    /**
     * @param pageable
     * @param dateStart
     * @param dateEnd
     * @return list use point , status OK
     * @author DongPV
     */
    @GetMapping("/use-point")
    public ResponseEntity<?> findAllUsePoint(@PageableDefault(size = 3) Pageable pageable, LocalDate dateStart, LocalDate dateEnd) {
        Page<Customer> customers = iCustomerService.searchUsePoint(pageable, dateStart, dateEnd);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
