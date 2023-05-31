package com.example.dncinema.service.discount;

import com.example.dncinema.model.Discount;
import com.example.dncinema.projection.IDiscountProjection;

import java.util.List;

public interface IDiscountService {
    List<Discount> findAllDiscount();

    Discount findById(int id);
}
