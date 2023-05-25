package com.example.dncinema.controller.customer;

import com.example.dncinema.dto.customerDTO.CustomerDTO;
import com.example.dncinema.model.Customer;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class RegisterCustomerController {
    @Autowired
    private ICustomerService customerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createCustomerAccount(@RequestBody CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO, customerDTO.getAccountUser().getNameAccount(),
                customerDTO.getAccountUser().getPasswordAccount());
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update")
    public void updateCustomerAccount(@RequestBody CustomerDTO customerDTO,
                                      @PathVariable("id") Integer id) {
        customerService.updateRegisterCustomer(customerDTO, id);
    }
}
