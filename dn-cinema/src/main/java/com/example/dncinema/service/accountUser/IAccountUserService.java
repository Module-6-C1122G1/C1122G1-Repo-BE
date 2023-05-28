package com.example.dncinema.service.accountUser;

import com.example.dncinema.dto.accounUserDTO.AccountUserDTO;
import com.example.dncinema.model.AccountUser;
import com.example.dncinema.model.Customer;

public interface IAccountUserService {
    AccountUser findAccountUserByNameAccount(String name);
    Boolean existByNameAccount(String name);
    AccountUser saveAccountUser(AccountUser accountUser);
    AccountUser findAccountUserByEmail(String email);
    int sendEmail(String email);
    void updatePassword(AccountUserDTO accountUserDTO, Integer id);

    AccountUser findById(int id);
}
