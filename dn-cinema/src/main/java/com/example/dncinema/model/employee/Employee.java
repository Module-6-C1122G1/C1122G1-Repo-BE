package com.example.dncinema.model.employee;

import com.example.dncinema.model.Account;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Column(name = "name_employee", columnDefinition = "varchar(45)")
    private String nameEmployee;
    @Column(name = "identity", columnDefinition = "varchar(15)")
    private String identity;
    @Column(name = "img", columnDefinition = "varchar(255)")
    private String img;
    @Column(name = "email", columnDefinition = "varchar(45)")
    private String email;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @Column(name = "gender", columnDefinition = "varchar(45)")
    private String gender;
    @Column(name = "address", columnDefinition = "varchar(45)")
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;

    public Employee() {
    }

    public Employee(Integer idEmployee, String nameEmployee, String identity, String img, String email, Integer phoneNumber, String gender, String address, Account account) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.identity = identity;
        this.img = img;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.account = account;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
