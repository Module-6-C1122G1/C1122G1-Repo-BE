package com.example.dncinema.service.accountUser.impl;

import com.example.dncinema.model.AccountUser;
import com.example.dncinema.repository.IAccountUserRepository;
import com.example.dncinema.service.accountUser.IAccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author ChinhLV
 * @Param name
 * @return AccountUser findAccountUserByNameAccount(String name)
 * Phương thức sử dụng để tìm kiếm account dựa vào tên account được truyền vào
 * Kết quả trả về là đối tượng AccountUser nếu thành công
 * @Param name
 * @return Boolean existByNameAccount(String name)
 * Phương thức sử dụng check tồn tại của tên account hay không
 * Nếu tên account đã tồn tại trong db thì trả về true, ngược lại false.
 * @Param AccountUser
 * @return AccountUser saveAccountUser(AccountUser accountUser)
 * Phương thức sử dụng để đối tượng của AccountUser về database
 */
@Service
public class accountUserService implements IAccountUserService {
    @Autowired
    private IAccountUserRepository accountUserRepository;
    @Override
    public AccountUser findAccountUserByNameAccount(String name) {
        AccountUser accountUser = accountUserRepository.findAccountUserByNameAccount(name);
        System.out.println(accountUser);
        return accountUser;
    }

    @Override
    public Boolean existByNameAccount(String name) {
        AccountUser accountUser = accountUserRepository.findAccountUserByNameAccount(name);
        if (accountUser != null) {
            return true;
        }
        return false;
    }

    @Override
    public AccountUser saveAccountUser(AccountUser accountUser) {
        return accountUserRepository.save(accountUser);
    }
}
