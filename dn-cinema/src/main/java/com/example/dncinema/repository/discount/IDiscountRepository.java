package com.example.dncinema.repository.discount;

import com.example.dncinema.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDiscountRepository extends JpaRepository<Discount, Integer> {
    @Query(value = "SELECT * FROM Discount WHERE name_discount like concat('%',:name,'%') and is_deleted = false order by id_discount asc", nativeQuery = true)
    Page<Discount> searchName(@Param("name") String name, Pageable pageable);

    Discount findById(Long id);
}
