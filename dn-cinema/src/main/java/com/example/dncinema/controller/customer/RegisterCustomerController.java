package com.example.dncinema.controller.customer;

import com.example.dncinema.dto.customerDTO.CustomerDTO;
import com.example.dncinema.model.Customer;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/public")
@CrossOrigin("*")
public class RegisterCustomerController {
    @Autowired
    private ICustomerService customerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Customer> findAll() {
        return customerService.findAll();
    }


    /**
     * Created by: TruongNN
     * Date created: 24/05/2023
     * Function: add data customer  into Database
     *
     * @param customerDTO
     * @param bindingResult
     * @return
     */

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public ResponseEntity<?> createCustomerAccount(@Valid @RequestBody CustomerDTO customerDTO,
                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: TruongNN
     * Date created: 24/05/2023
     * Function: Update data employee  into Database
     *
     * @param customerDTO
     * @param id
     * @param bindingResult
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCustomerAccount(@Valid @RequestBody CustomerDTO customerDTO,
                                                   @PathVariable("id") Integer id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Customer customer = customerService.findById(id);
        BeanUtils.copyProperties(customerDTO, customer);
        customerService.updateRegisterCustomer(customerDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
