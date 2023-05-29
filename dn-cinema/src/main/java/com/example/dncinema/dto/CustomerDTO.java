package com.example.dncinema.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class CustomerDTO {
    private Integer idCustomer;
    private String nameCustomer;
    @PositiveOrZero(message = "Không được là số âm")
    private Double pointCustomer;
    private String gender;
    private String phone;
    private String address;
    private String identityCard;
    private String email;
    private TypeCustomerDTO typeCustomerDTO;

    public CustomerDTO() {
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

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TypeCustomerDTO getTypeCustomerDTO() {
        return typeCustomerDTO;
    }


    public void setTypeCustomerDTO(TypeCustomerDTO typeCustomerDTO) {
        this.typeCustomerDTO = typeCustomerDTO;
    }
}
