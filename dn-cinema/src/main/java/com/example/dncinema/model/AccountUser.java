package com.example.dncinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_user")
public class AccountUser {
    @Id
    @Column(name = "name_account", columnDefinition = "varchar(255)")
    private String nameAccount;
    @Column(name = "password_account", columnDefinition = "varchar(255)")
    private String passwordAccount;

    public AccountUser() {
    }

    public AccountUser(String nameAccount, String passwordAccount) {
        this.nameAccount = nameAccount;
        this.passwordAccount = passwordAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPasswordAccount() {
        return passwordAccount;
    }

    public void setPasswordAccount(String passwordAccount) {
        this.passwordAccount = passwordAccount;
    }
}
