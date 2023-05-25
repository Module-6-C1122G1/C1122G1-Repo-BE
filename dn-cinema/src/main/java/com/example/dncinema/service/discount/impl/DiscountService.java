package com.example.dncinema.service.discount.impl;

import com.example.dncinema.dto.discount.DiscountDTO;
import com.example.dncinema.model.Discount;
import com.example.dncinema.repository.discount.IDiscountRepository;
import com.example.dncinema.service.discount.IDiscountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountService implements IDiscountService {
    @Autowired
    private IDiscountRepository discountRepository;

    @Override
    public Discount findByIdDiscount(Long id) {
        return discountRepository.findByIdDiscount(id);
    }

    @Override
    public List<Discount> findAllDiscount() {
        return discountRepository.findAllDiscount();
    }
}
