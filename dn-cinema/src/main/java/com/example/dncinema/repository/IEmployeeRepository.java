package com.example.dncinema.repository;

import com.example.dncinema.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

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
    @Query(value = "SELECT * FROM employee e JOIN accout_user a WHERE (a.name_account LIKE CONCAT('%', :code, '%') " +
            "OR e.name_employee LIKE CONCAT('%', :name, '%') " +
            "OR e.phone LIKE CONCAT('%', :phoneNumber, '%')) " +
            "AND c.is_delete = false", nativeQuery = true)
    Page<Employee> searchEmployeeInfo(Pageable pageable,
                                      @Param("code") String code,
                                      @Param("name") String name,
                                      @Param("phoneNumber") String phoneNumber);


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
