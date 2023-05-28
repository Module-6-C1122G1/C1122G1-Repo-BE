package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Column(name = "name_customer",columnDefinition = "varchar(255)")
    private String nameCustomer;
    @Column(name = "point_customer")
    private Double pointCustomer;
    @Column(name = "gender",columnDefinition = "varchar(45)")
    private String gender;
    @Column(name = "phone",columnDefinition = "varchar(25)")
    private String phone;
    @Column(name = "address",columnDefinition = "varchar(255)")
    private String address;
    @Column(name = "email",columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "identity_card",columnDefinition = "varchar(45)")
    private String identityCard;

    @ManyToOne
    @JoinColumn(name = "id_type_customer")
    private TypeCustomer typeCustomer;
    @ManyToOne
    @JoinColumn(name = "name_account")
    private AccountUser accountUser;

    public Customer() {
    }

    public Customer(Integer idCustomer, String nameCustomer, Double pointCustomer, String gender, String phone, String address, String email, String identityCard, TypeCustomer typeCustomer, AccountUser accountUser) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.pointCustomer = pointCustomer;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.identityCard = identityCard;
        this.typeCustomer = typeCustomer;
        this.accountUser = accountUser;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Double getPointCustomer() {
        return pointCustomer;
    }

    public void setPointCustomer(Double pointCustomer) {
        this.pointCustomer = pointCustomer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }
}
