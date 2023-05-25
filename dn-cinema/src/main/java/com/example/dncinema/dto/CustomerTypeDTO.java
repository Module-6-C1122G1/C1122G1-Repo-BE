package com.example.dncinema.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;

public class CustomerTypeDTO implements Validator {
    private Integer idTypeCustomer;
    private String nameTypeCustomer;

    public Integer getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(Integer idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
    }

    public String getNameTypeCustomer() {
        return nameTypeCustomer;
    }

    public void setNameTypeCustomer(String nameTypeCustomer) {
        this.nameTypeCustomer = nameTypeCustomer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
