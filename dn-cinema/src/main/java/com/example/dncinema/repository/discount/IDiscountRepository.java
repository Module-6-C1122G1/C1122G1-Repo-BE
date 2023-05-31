package com.example.dncinema.repository.discount;

import com.example.dncinema.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IDiscountRepository extends JpaRepository<Discount, Integer> {
    @Query(value = "SELECT * FROM discount ", nativeQuery = true)
    List<Discount> findAllDiscount();

    @Query(value = "SELECT * FROM discount WHERE id_Discount=:idDiscount ", nativeQuery = true)
    Discount findByIdDiscount(@Param("idDiscount")Integer idDiscount);
}
