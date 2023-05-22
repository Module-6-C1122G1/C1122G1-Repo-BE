package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "role_user")
public class RoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role_user")
    private Integer idRoleUser;
    @Column(name = "name_role_user",columnDefinition = "varchar(45)")
    private String nameRoleUser;

    public RoleUser() {
    }

    public RoleUser(Integer idRoleUser, String nameRoleUser) {
        this.idRoleUser = idRoleUser;
        this.nameRoleUser = nameRoleUser;
    }

    public Integer getIdRoleUser() {
        return idRoleUser;
    }

    public void setIdRoleUser(Integer idRoleUser) {
        this.idRoleUser = idRoleUser;
    }

    public String getNameRoleUser() {
        return nameRoleUser;
    }

    public void setNameRoleUser(String nameRoleUser) {
        this.nameRoleUser = nameRoleUser;
    }
}
