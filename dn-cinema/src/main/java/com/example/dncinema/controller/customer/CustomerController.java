package com.example.dncinema.controller.customer;

import com.example.dncinema.dto.CustomerDTO;
import com.example.dncinema.model.Customer;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
     * @return customerService.findAll();
     * Phương thức sử dụng để hiển thị danh sách thành viên
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Customer> showAll() {
        return customerService.findAll();
    }


    /**
     * @author ThanhNV
     * @param id
     * @param customer
     * @return ResponseEntity<>(HttpStatus.OK);
     * Phương thức sử dụng để chỉnh sửa danh sách thành viên
     */
    @PatchMapping("/{id}")
    public ResponseEntity<List<Customer>> edit(@PathVariable("id") int id, @RequestBody Customer customer) {
        // Sử dụng id trong phần xử lý chỉnh sửa dữ liệu
        customerService.findById(id);
        if (customerService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

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

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Integer id, @Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        new CustomerDTO().validate(customerDTO, bindingResult);
        customerDTO.setIdCustomer(id);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            customerService.updateCustomer(String.valueOf(customerDTO.getIdCustomer()),customerDTO.getNameCustomer(),customerDTO.getGender(),customerDTO.getPhone(),
                    customerDTO.getAddress(),customerDTO.getEmail(),customerDTO.getIdentityCard(),customerDTO.getPointCustomer(),customerDTO.getCustomerTypeDTO().getIdTypeCustomer(),id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
