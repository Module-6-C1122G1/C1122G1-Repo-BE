package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Integer idAccount;
    @Column(name = "name_account", columnDefinition = "varchar(45)")
    private String nameAccount;
    @Column(name = "password", columnDefinition = "varchar(45)")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_role_user")
    private RoleUser roleUser;

    public Account() {
    }

    public Account(Integer idAccount, String nameAccount, String password, RoleUser roleUser) {
        this.idAccount = idAccount;
        this.nameAccount = nameAccount;
        this.password = password;
        this.roleUser = roleUser;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }
}
