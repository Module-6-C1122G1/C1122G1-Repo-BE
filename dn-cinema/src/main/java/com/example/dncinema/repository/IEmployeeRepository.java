package com.example.dncinema.repository;

import com.example.dncinema.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Create by: NghiaTT,
     * Date create : 24/05/2023
     * Function : Add new employee to database
     *
     * @param nameEmployee
     * @param phone
     * @param address
     * @param gender
     * @param dateOfBirth
     * @param img
     * @param email
     * @param identityCard
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "insert into employee(name_employee , phone , address , gender , date_of_birth , img_employee , email , identity_card , id) values (:name_employee,:phone,:address,:gender ,:date_of_birth , :img_employee , :email , :identity_card , :id)", nativeQuery = true)
    void saveEmployee(@Param("name_employee") String nameEmployee
            , @Param("phone") String phone
            , @Param("address") String address
            , @Param("gender") String gender
            , @Param("date_of_birth") String dateOfBirth
            , @Param("img_employee") String img
            , @Param("email") String email
            , @Param("identity_card") String identityCard
            , @Param("id") Integer id
    );


    /**
     * Create by: NghiaTT,
     * Date create : 24/05/2023
     * Function : Update employee to database
     *
     * @param nameEmployee
     * @param phone
     * @param address
     * @param gender
     * @param dateOfBirth
     * @param img
     * @param email
     * @param identityCard
     * @param idAccount
     * @param employeeId
     */
    @Modifying
    @Transactional
    @Query(value = "update employee set name_employee = :name_employee, phone = :phone , address = :address , date_of_birth = :date_of_birth ,gender = :gender,img_employee = :img_employee ,email = :email,identity_card = :identity_card, id = :id WHERE id_employee = :id_employee", nativeQuery = true)
    void updateEmployeeWithAccount(
            @Param("name_employee") String nameEmployee
            , @Param("phone") String phone
            , @Param("address") String address
            , @Param("gender") String gender
            , @Param("date_of_birth") String dateOfBirth
            , @Param("img_employee") String img
            , @Param("email") String email
            , @Param("identity_card") String identityCard
            , @Param("id") Integer idAccount
            , @Param("id_employee") Integer employeeId);

    /**
     * Create by: NghiaTT,
     * Date create : 24/05/2023
     * Function : Find employee by id
     *
     * @param employeeId
     * @return
     */
    @Transactional
    @Query(value = "select * from employee where id_employee = :id_employee", nativeQuery = true)
    Employee findByIdEmployee(@Param("id_employee") Integer employeeId);
}
