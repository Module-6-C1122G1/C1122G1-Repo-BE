package com.example.dncinema.repository.discount;

import com.example.dncinema.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface IDiscountRepository extends JpaRepository<Discount, Integer> {
    @Query(value = "SELECT * FROM Discount WHERE name_discount like concat('%',:name,'%') and is_deleted = false order by id_discount asc", nativeQuery = true)
    Page<Discount> searchName(@Param("name") String name, Pageable pageable);

    Discount findById(Long id);
    /**
     * Create by: HoangPT,
     * Date create : 24/05/2023
     * Function : Add new discount to database
     *
     * @Param("nameDiscount") String nameDiscount,
     * @Param("dateStart") LocalDate dateStart,
     * @Param("dateEnd") LocalDate dateEnd,
     * @Param("describeDiscount") String describeDiscount,
     * @Param("percentDiscount") Double percentDiscount
     */
    @Query(value = "insert into discount( name_discount, date_start,date_end, describe_discount, percent_discount) " +
            "value (:nameDiscount,:dateStart,:dateEnd,:describeDiscount,:percentDiscount)",
            nativeQuery = true)
    void createDiscount(
            @Param("nameDiscount") String nameDiscount,
            @Param("dateStart") LocalDate dateStart,
            @Param("dateEnd") LocalDate dateEnd,
            @Param("describeDiscount") String describeDiscount,
            @Param("percentDiscount") Double percentDiscount
    );

    /**
     * Create by: HoangPT,
     * Date create : 24/05/2023
     * Function : Find discount information in database by id
     *
     * @param idDiscount
     */
    @Query(value = "select name_discount, date_start,date_end, describe_discount, percent_discount " +
            "from discount where id_discount = :idDiscount", nativeQuery = true)
    Discount findDiscountById(@Param("idDiscount") int idDiscount);

    /**
     * Create by: HoangPT,
     * Date create : 24/05/2023
     * Function : Edit information a discount in database
     *
     * @Param("idDiscount") String idDiscount
     * @Param("nameDiscount") String nameDiscount
     * @Param("dateStart") LocalDate dateStart
     * @Param("dateEnd") LocalDate dateEnd
     * @Param("describeDiscount") String describeDiscount
     * @Param("percentDiscount") String percentDiscount
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
    void updateDiscount(
            @Param("idDiscount") Integer idDiscount,
            @Param("nameDiscount") String nameDiscount,
            @Param("dateStart") LocalDate dateStart,
            @Param("dateEnd") LocalDate dateEnd,
            @Param("describeDiscount") String describeDiscount,
            @Param("percentDiscount") Double percentDiscount
    );
}
