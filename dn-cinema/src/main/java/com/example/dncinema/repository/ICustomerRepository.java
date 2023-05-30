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
import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * ThanhNV
     * Retrieves a paginated list of customer information from the database.
     *
     * Use a query to call a list from the database to perform the list function
     * @param
     * @return a Page object containing the requested subset of customer information.
     *
     */
    @Query(value = "select * from dn_cinema.customer where name_customer like %:nameSearch%", nativeQuery = true)
    List<Customer> findAllAndSearch(@Param("nameSearch") String nameSearch);

    /**
     * @param idCustomer
     * @param nameCustomer
     * @param gender
     * @param address
     * @param email
     * @param phone
     * @param pointCustomer
     * @param typeCustomer
     * @param identityCard
     */
    @Modifying
    @Transactional
    @Query(value = "update dn_cinema.customer set name_customer = :nameCustomer, phone = :phone,\n" +
            "            address = :address,\n" +
            "            email = :email,\n" +
            "            identity_card = :identityCard "+
            "            where id_customer = :idCustomer", nativeQuery = true)

    void updateCustomer(
            @Param("nameCustomer") String nameCustomer,
            @Param("phone") String phone,
            @Param("address") String address,
            @Param("email") String email,
            @Param("idCustomer") Integer idCustomer,
            @Param("identityCard") String identityCard);


    /**
     * @author ThanhNV
     * Search for customers based on customer ID.
     * @param idCustomer ID of the customer to search.
     * @return The client corresponds to the provided ID.
     */
    @Query(value = "select * from dn_cinema.customer where id_customer = :id_customer", nativeQuery = true)
    Customer findByIdCustomer(@Param("id_customer") Integer idCustomer);

}
