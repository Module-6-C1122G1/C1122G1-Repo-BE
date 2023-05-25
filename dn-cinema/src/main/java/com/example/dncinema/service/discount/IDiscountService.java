package com.example.dncinema.service.discount;

import com.example.dncinema.dto.discount.DiscountDTO;
import com.example.dncinema.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface IDiscountService {
    Page<DiscountDTO> findByName(String name, Pageable pageable);

    void delete(Long id);
    /**
     * Create by: HoangPT,
     * Date create : 24/05/2023
     * Function : Add new discount
     *
     * @Param("nameDiscount") String nameDiscount,
     * @Param("dateStart") LocalDate dateStart,
     * @Param("dateEnd") LocalDate dateEnd,
     * @Param("describeDiscount") String describeDiscount,
     * @Param("percentDiscount") Double percentDiscount
     */
    void createDiscount(String nameDiscount, LocalDate dateStart, LocalDate dateEnd, String describeDiscount,
                        Double percentDiscount);
    /**
     * Create by: HoangPT,
     * Date create : 24/05/2023
     * Function : Find discount information by id
     *
     * @param idDiscount
     */
    @Query(value = "select name_discount, date_start,date_end, describe_discount, percent_discount " +
            "from discount where id_discount = :idDiscount", nativeQuery = true)
    Discount findDiscountById(@Param("idDiscount") int idDiscount);

    /**
     * Create by: HoangPT,
     * Date create : 24/05/2023
     * Function : Edit information a discount
     *
     * @Param("idDiscount") Integer idDiscount
     * @Param("nameDiscount") String nameDiscount
     * @Param("dateStart") LocalDate dateStart
     * @Param("dateEnd") LocalDate dateEnd
     * @Param("describeDiscount") String describeDiscount
     * @Param("percentDiscount") Double percentDiscount
     */
    @Query(value = "update discount " +
            "set idDiscount = :idDiscount," +
            "name_discount = :nameDiscount," +
            "date_start = :dateStart," +
            "date_end = :dateEnd," +
            "describe_discount = :describeDiscount," +
            "percent_discount = :percentDiscount" +
            " WHERE id_discount = :idDiscount",
            nativeQuery = true)
    void updateDiscount(Integer idDiscount, String nameDiscount, LocalDate dateStart, LocalDate dateEnd,
                        String describeDiscount, Double percentDiscount);
}
