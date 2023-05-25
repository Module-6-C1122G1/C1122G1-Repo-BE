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

    /**
     * Author: TuanLT.
     * Date: 24/05/2023.
     * @param name "Tham số name dùng để tìm kiếm trong danh sách khuyến mãi".
     * @param pageable "Tham số pageable dùng để phân trang".
     * @return "Trả về danh sách khuyến mãi ban đầu có phân trang, nếu người dùng tiến hành tìm kiếm thì sẽ trả về 1 danh sách sau khi người dùng search (có phân trang)."
     */

    @Override
    public Page<DiscountDTO> findByName(String name, Pageable pageable) {
        List<DiscountDTO> discountDTOList = new ArrayList<>();
        Page<Discount> discountPage = discountRepository.searchName(name, pageable);
        DiscountDTO discountDTO;
        for (Discount discount : discountPage) {
            discountDTO = new DiscountDTO();
            BeanUtils.copyProperties(discount, discountDTO);
            discountDTOList.add(discountDTO);
        }
        return new PageImpl<>(discountDTOList, discountPage.getPageable(), discountPage.getTotalElements());
    }

    @Override
    public void save(Discount discount) {
        discountRepository.save(discount);
    }

    /**
     * Author: TuanLT.
     * Date: 24/05/2023.
     * @param id "Tham số id - Nhằm tìm kiếm id của khuyến mãi mà người dùng muốn xóa".
     */
    @Override
    public void delete(Long id) {
        Discount discount = discountRepository.findById(id);
        discount.setDeleted(true);
        discountRepository.save(discount);
    }
}
