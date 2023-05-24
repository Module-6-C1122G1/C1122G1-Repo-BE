package com.example.dncinema.controller.customer;

import com.example.dncinema.model.Customer;
import com.example.dncinema.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @return customerService.findAll();
     * Phương thức sử dụng để hiển thị danh sách thành viên
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Customer> showAll() {
        return customerService.findAll();
    }



//    @PutMapping("")
//    public ResponseEntity <List<Customer>> edit (@RequestBody Customer customer) {
//        customerService.save(customer);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    /**
     * @author ThanhNV
     * @param id
     * @param customer
     * @return ResponseEntity<>(HttpStatus.OK);
     * Phương thức sử dụng để chỉnh sửa danh sách thành viên
     */
    @PutMapping("/{id}")
    public ResponseEntity<List<Customer>> edit(@PathVariable("id") int id, @RequestBody Customer customer) {
        // Sử dụng id trong phần xử lý chỉnh sửa dữ liệu
        customerService.findById(id);
        if (customerService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
