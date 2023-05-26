package com.example.dncinema.dto;

import com.example.dncinema.model.AccountUser;

import javax.validation.constraints.NotBlank;

public class EmployeeDTO {
    private Integer idEmployee;
    @NotBlank(message = "Không được để trống")
    private String nameEmployee;
    @NotBlank(message = "Không được để trống")
    private String phone;
    @NotBlank(message = "Không được để trống")
    private String address;
    @NotBlank(message = "Không được để trống")
    private String gender;
    @NotBlank(message = "Không được để trống")
    private String imgEmployee;
    @NotBlank(message = "Không được để trống")
    private String email;
    @NotBlank(message = "Không được để trống")
    private String identityCard;
    private AccountUser accountUser;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer idEmployee, String nameEmployee, String phone, String address, String gender, String imgEmployee, String email, String identityCard, AccountUser accountUser) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.imgEmployee = imgEmployee;
        this.email = email;
        this.identityCard = identityCard;
        this.accountUser = accountUser;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImgEmployee() {
        return imgEmployee;
    }

    public void setImgEmployee(String imgEmployee) {
        this.imgEmployee = imgEmployee;
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

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }
}
