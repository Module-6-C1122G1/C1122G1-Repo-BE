package com.example.dncinema.service.discount.impl;

import com.example.dncinema.model.Discount;
import com.example.dncinema.repository.discount.IDiscountRepository;
import com.example.dncinema.service.discount.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService implements IDiscountService {
    @Autowired
    private IDiscountRepository discountRepository;

    @Override
    public List<Discount> findAllDiscount() {
        return discountRepository.findAllDiscount();
    }

    @Override
    public Discount findById(int id) {
        return discountRepository.findByIdDiscount(id);
    }
}
