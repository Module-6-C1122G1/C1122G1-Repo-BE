package com.example.dncinema.repository;

import com.example.dncinema.model.AccountUser;
import com.example.dncinema.model.Customer;
import com.example.dncinema.model.TypeCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * ThanhNV
     * Retrieves a paginated list of customer information from the database.
     *
     * Use a query to call a list from the database to perform the list function
     * @param pageable
     * @return a Page object containing the requested subset of customer information.
     *
     */
    @Query(value = "select * from dn_cinema.customer", nativeQuery = true)
    Page<Customer> searchCustomerInfo(Pageable pageable);

//    /**
//     * @param idCustomer
//     * @param nameCustomer
//     * @param gender
//     * @param address
//     * @param email
//     * @param phone
//     * @param pointCustomer
//     * @param typeCustomer
//     * @param identityCard
//     * @param id
//     */
//    @Modifying
//    @Transactional
//    @Query(value = "update customers set id_customer = :id_customer,  name_customer = :name_customer, " +
//            "gender = :gender ,  point = : point, phone = :phone,  address = :address,  email = :email, \n" +
//            "total_amount = :total_amount,  id_type_customer = :id_type_customer,  identity_card = :identity_card" +
//            "WHERE id_customer = :id_customer",
//            nativeQuery = true)
//
//    void updateCustomer(
//            @Param("idCustomer") String idCustomer,
//            @Param("nameCustomer") String nameCustomer,
//            @Param("gender") String gender,
//            @Param("address") String address,
//            @Param("email") Double email,
//            @Param("phone") String phone,
//            @Param("pointCustomer") TypeCustomer pointCustomer,
//            @Param("typeCustomer") String typeCustomer,
//            @Param("identityCard") Integer identityCard,
//            @Param("id") AccountUser id
//    );
//
//    @Modifying
//    @Transactional
//    @Query(value = "insert into customers( id_customer, name_customer, gender, address, email, phone,total_amount, point,id_type_customer) " +
//            "value " +
//            "(:id_customer, :name_customer, :gender, :address, :email, :phone, :total_amount, :point,:id_type_customer)",
//            nativeQuery = true)
//    void saveCustomer(
//            @Param("idCustomer") String idCustomer,
//            @Param("nameCustomer") String nameCustomer,
//            @Param("gender") String gender,
//            @Param("address") String address,
//            @Param("email") String email,
//            @Param("phone") String phone,
//            @Param("pointCustomer") double pointCustomer,
//            @Param("typeCustomer") Integer typeCustomer,
//            @Param("identityCard") String identityCard)
//            ;
//
//
//    @Transactional
//    @Query(value = "select * from customers where id_customer = :id_customer", nativeQuery = true)
//    Customer findByIdCustomer(@Param("id_customer") Integer idCustomer);

}
