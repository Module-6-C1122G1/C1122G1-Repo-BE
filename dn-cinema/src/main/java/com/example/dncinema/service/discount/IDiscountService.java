package com.example.dncinema.service.discount;

import com.example.dncinema.dto.discount.DiscountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDiscountService {
    Page<DiscountDTO> findByName(String name, Pageable pageable);

//    Discount findById(Long id);
//
//    void save(Discount discount);

    void delete(Long id);
}
