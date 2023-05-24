package com.example.dncinema.controller.customer;

import com.example.dncinema.model.TypeCustomer;
import com.example.dncinema.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customerType")
public class CustomerTypeController {
    @Autowired
    ICustomerTypeService customerTypeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<TypeCustomer> showAll() {
        return customerTypeService.findAllTypeCustomer();
    }
}