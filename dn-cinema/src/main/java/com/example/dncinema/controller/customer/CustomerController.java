package com.example.dncinema.controller.customer;

import com.example.dncinema.dto.CustomerDTO;
import com.example.dncinema.model.Customer;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    /**
     * @author ThanhNV
     *  Retrieves a paginated list of customers.
     *
     *  This method is used to display the list of customers in a paginated manner. It returns a Page object containing
     *  a subset of customers based on the provided pagination parameters.
     *
     *   the pagination parameters for retrieving the list of customers.
     * @return a Page object containing the requested subset of customers.
     * The method used to display the list of members
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Customer> showAll() {
        return customerService.findAll();
    }


    /**
     * Search and return customer information based on id.
     * @author ThanhNV
     * @param id
     * @return ResponseEntity<Customer>;
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findByCustomerId(@PathVariable Integer id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


//    @ResponseStatus(HttpStatus.OK)
//    @PutMapping("/{id}")
//    public void updateCustomer(@RequestBody CustomerDTO customerDTO,
//                                          @PathVariable("id") Integer id) {
//        customerService.updateCustomer(customerDTO, id);
//    }

    /**
     * Created by: ThanhNV
     * Date created: 05/25/2023
     * @param id
     * Function: edit customer data if ID is not found then return HttpStatus.NOT_FOUND,
     * if found ID then edit data in DB and return HttpStatus.OK
     *
     * @return if has errors then return HttpStatus.Not_FOUND else ResponseEntity<>(HttpStatus.OK);
     * Phương thức sử dụng để chỉnh sửa danh sách thành viên
     */

//    @PatchMapping("/update/{id}")
//    public ResponseEntity<?> updateCustomer(@PathVariable("id") Integer id, @Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
//        new CustomerDTO().validate(customerDTO, bindingResult);
//        customerDTO.setIdCustomer(id);
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
//        }
//        Customer customer = customerService.findById(id);
//        if (customer == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            customerService.updateCustomer(String.valueOf(customerDTO.getIdCustomer()),customerDTO.getNameCustomer(),customerDTO.getGender(),customerDTO.getPhone(),
//                    customerDTO.getAddress(),customerDTO.getEmail(),customerDTO.getIdentityCard(),customerDTO.getPointCustomer(),customerDTO.getCustomerTypeDTO().getIdTypeCustomer(),id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//    }
}
