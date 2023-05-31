package com.example.dncinema.service.discount;

import com.example.dncinema.dto.discount.DiscountDTO;
import com.example.dncinema.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IDiscountService {
    Page<DiscountDTO> findByName(String name, Pageable pageable);

    Optional<Discount> findById(int id);
//
    void save(Discount discount);

    boolean delete(int id);
}
