package com.example.dncinema.repository;
import com.example.dncinema.model.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

public interface IAccountRepository extends JpaRepository<AccountUser, Integer> {

    @Query(value = "select * from account_user where name_account like :nameAccount", nativeQuery = true)
    AccountUser findAccountUserByNameAccount(String nameAccount);

    @Modifying
    @Transactional
    @Query(value = "insert into account_user(name_account , password_account) values (:name_account , :password_account)", nativeQuery = true)
    void createAccountUser(@Param("name_account") String nameAccount
            , @Param("password_account") String password_account);

    @Modifying
    @Transactional
    @Query(value = "update account_user set name_account = :name_account , password_account = :password_account WHERE id = :id", nativeQuery = true)
    void updateAccount(
            @Param("name_account") String nameAccount
            , @Param("password_account") String passwordAccount
            , @Param("id") Integer id);


}
