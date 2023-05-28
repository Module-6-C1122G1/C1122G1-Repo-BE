package com.example.dncinema.repository;

import com.example.dncinema.model.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountUserRepository extends JpaRepository<AccountUser, Integer> {
    @Query(value = "select * from account_user where name_account like :nameAccount", nativeQuery = true)
    AccountUser findAccountUserByNameAccount(String nameAccount);
    @Query(value = "select * from account_user where name_account like :email", nativeQuery = true)
    AccountUser findAccountUserByEmail(String email);
}
