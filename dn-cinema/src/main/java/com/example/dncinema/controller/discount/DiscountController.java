package com.example.dncinema.controller.discount;

import com.example.dncinema.dto.discount.DiscountDTO;
import com.example.dncinema.model.Discount;
import com.example.dncinema.service.discount.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("detailDiscount")
    public ResponseEntity<Discount> showListDetail(@RequestParam(defaultValue = "", required = false) Long id) {
        Discount discount = discountService.findByIdDiscount(id);
        if (discount == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }
}
