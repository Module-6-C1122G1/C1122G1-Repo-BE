package com.example.dncinema.controller.discount;

import com.example.dncinema.dto.discount.DiscountDTO;
import com.example.dncinema.repository.discount.IDiscountRepository;
import com.example.dncinema.service.discount.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/discount")
@CrossOrigin("*")
public class DiscountController {
    @Autowired
    private IDiscountService discountService;

    @Autowired
    private IDiscountRepository discountRepository;

    /**
     * Create: TuanLT.
     * Date create: 24/05/2023.
     *
     * @param name     "Dùng để tìm kiếm khuyến mãi theo tên".
     * @param pageable "Dùng để phân trang".
     * @return "Trả về Page hiển thị danh sách khuyến mãi, nếu người dùng tiến hành tìm kiếm thì Page này sẽ hiển thị danh sách được tìm kiếm theo tên".
     */

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public Page<DiscountDTO> showList(
            @PageableDefault(direction = Sort.Direction.DESC, size = 5) Pageable pageable, @RequestParam(required = false, defaultValue = "") String name) {
        return discountService.findByName(name, pageable);
    }

    /**
     * Create: TuanLT
     * Date create: 24/05/2023.
     *
     * @param id "Tìm kiếm id của 1 khuyến mãi và xóa nó".
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        if (!discountRepository.existsById(id)) {
            return new ResponseEntity<>("ID không tồn tại!", HttpStatus.NOT_FOUND);
        }
        discountService.delete(id);
        return new ResponseEntity<>("Xóa thành công!", HttpStatus.OK);
    }

}
