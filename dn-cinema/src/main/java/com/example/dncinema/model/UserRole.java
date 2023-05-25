package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_roles")
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "name_account")
    private AccountUser accountUser;

    public UserRole() {
    }

    public UserRole(Roles roles, AccountUser accountUser) {
        this.roles = roles;
        this.accountUser = accountUser;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }
}
