package com.example.dncinema.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class CustomerDTO implements Validator {

    private Integer idCustomer;
    private String nameCustomer;
    private Double pointCustomer;
    private String gender;
    private String phone;
    private String address;
    private String email;
    private String identityCard;

    private CustomerTypeDTO customerTypeDTO;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer idCustomer, String nameCustomer, Double pointCustomer, String gender, String phone, String address, String email, String identityCard, CustomerTypeDTO customerTypeDTO) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.pointCustomer = pointCustomer;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.identityCard = identityCard;
        this.customerTypeDTO = customerTypeDTO;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public CustomerTypeDTO getCustomerTypeDTO() {
        return customerTypeDTO;
    }

    public void setCustomerTypeDTO(CustomerTypeDTO customerTypeDTO) {
        this.customerTypeDTO = customerTypeDTO;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
