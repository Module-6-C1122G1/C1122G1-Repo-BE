package com.example.dncinema.controller.discount;

import com.example.dncinema.model.Discount;
import com.example.dncinema.service.discount.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount")
@CrossOrigin("*")
public class DiscountController {
    @Autowired
    private IDiscountService discountService;

    @GetMapping("")
    public ResponseEntity<List<Discount>> showListDiscount() {
        List<Discount> listDiscount = discountService.findAllDiscount();
        if (listDiscount.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listDiscount, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discount> findByIdDiscount(@PathVariable Integer id) {
        Discount detailDiscount = discountService.findById(id);
        if (detailDiscount == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detailDiscount, HttpStatus.OK);
    }

}
