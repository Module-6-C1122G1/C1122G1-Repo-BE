package com.example.dncinema.service.discount;

import com.example.dncinema.dto.discount.DiscountDTO;
import com.example.dncinema.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDiscountService {
//    Page<DiscountDTO> findByName(String name, Pageable pageable);

//    Discount findById(Long id);
//   void save(Discount discount);

    //    void delete(Long id);
    Discount findByIdDiscount(Long id);

    List<Discount> findAllDiscount();


}
