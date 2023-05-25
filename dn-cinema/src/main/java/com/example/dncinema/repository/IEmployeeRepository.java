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

    @Modifying
    @Transactional
    @Query(value = "insert into employee(name_employee , phone , address , gender , img_employee , email , identity_card , id) values (:name_employee,:phone,:address,:gender , :img_employee , :email , :identity_card , :id)", nativeQuery = true)
    void saveEmployee(@Param("name_employee") String nameEmployee
            , @Param("phone") String phone
            , @Param("address") String address
            , @Param("gender") String gender
            , @Param("img_employee") String img
            , @Param("email") String email
            , @Param("identity_card") String identityCard
            , @Param("id") Integer id
    );

    @Modifying
    @Query(value = "update employee set name_employee = :name_employee, phone = :phone , address = :address ,gender = :gender,img_employee = :img_employee ,email = :email,identity_card = :identity_card, id = :id WHERE id_employee = :id_employee", nativeQuery = true)
    void updateEmployeeWithAccount(
            @Param("name_employee") String nameEmployee
            , @Param("phone") String phone
            , @Param("address") String address
            , @Param("gender") String gender
            , @Param("img_employee") String img
            , @Param("email") String email
            , @Param("identity_card") String identityCard
            , @Param("id") Integer idAccount
            , @Param("id_employee") Integer employeeId);
}
