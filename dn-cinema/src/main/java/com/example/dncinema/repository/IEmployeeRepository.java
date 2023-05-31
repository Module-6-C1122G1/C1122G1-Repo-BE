package com.example.dncinema.repository;

import com.example.dncinema.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Create by: TienTHM,
     * Date create : 25/05/2023
     * Function : returns page containing customer data information
     * @param pageable
     * @param code
     * @param name
     * @param phoneNumber
     * @return
     */
    @Query(value = "SELECT e.* FROM employee e JOIN account_user a WHERE (a.name_account LIKE CONCAT('%', :search, '%')\n" +
            "    OR e.name_employee LIKE CONCAT('%', :search, '%')\n" +
            "    OR e.phone LIKE CONCAT('%', :search, '%'))\n" +
            "                                                 AND e.is_delete = false",
            countQuery = "select count(*) from (SELECT e.* FROM employee e JOIN account_user a WHERE (a.name_account LIKE CONCAT('%', :search, '%')\n" +
                    "            OR e.name_employee LIKE CONCAT('%', :search, '%')\n" +
                    "            OR e.phone LIKE CONCAT('%', :search, '%'))\n" +
                    "            AND e.is_delete = false ) as abc",nativeQuery = true)
    Page<Employee> searchEmployeeInfo(Pageable pageable,
                                      @Param("search") String search);


    /**
     * Created by: TienTHM
     * Date created: 25/05/2023
     * function: find employee by id
     * @param id
     * @return
     */
    @Query(value = "select * from employee where is_delete = false and id_employee =:idEmployee", nativeQuery = true)
    Employee findByEmployeeId(@Param("idEmployee") Integer id);

}
