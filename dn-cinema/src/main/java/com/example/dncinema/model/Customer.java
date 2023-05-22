package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Column(name = "name_customer", columnDefinition = "varchar(45)")
    private String nameCustomer;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "gender", columnDefinition = "varchar(45)")
    private String gender;
    @Column(name = "point")
    private Double point;
    @Column(name = "email", columnDefinition = "varchar(45)")
    private String email;
    @Column(name = "address", columnDefinition = "varchar(45)")
    private String address;
    @Column(name = "total_amount")
    private Double totalAmount;
    @Column(name = "identity_card", columnDefinition = "varchar(45)")
    private String identityCard;

    @ManyToOne
    @JoinColumn(name = "id_type_customer")
    private TypeCustomer typeCustomer;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;

    public Customer() {
    }

    public Customer(Integer idCustomer, String nameCustomer, Integer phone, String gender, Double point, String email, String address, Double totalAmount, String identityCard, TypeCustomer typeCustomer, Account account) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.phone = phone;
        this.gender = gender;
        this.point = point;
        this.email = email;
        this.address = address;
        this.totalAmount = totalAmount;
        this.identityCard = identityCard;
        this.typeCustomer = typeCustomer;
        this.account = account;
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
