package com.example.dncinema.repository;

import com.example.dncinema.model.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<AccountUser, Integer> {

}
