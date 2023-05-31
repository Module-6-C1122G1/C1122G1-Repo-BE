package com.example.dncinema.dto.discount;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class DiscountDTO implements Validator {
    private int idDiscount;
    @NotBlank(message = "Discount name cannot be left blank")
    private String nameDiscount;
    @NotBlank(message = "Cannot be left blank")
    private String imageDiscount;
    private String dateStart;
    private String dateEnd;
    @NotBlank(message = "Describe cannot be left blank")
    private String describeDiscount;
    private Double percentDiscount;

    public DiscountDTO() {
        //Tạo phương thức DiscountDTO() không có tham số!
    }

    public int getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getNameDiscount() {
        return nameDiscount;
    }

    public String getImageDiscount() {
        return imageDiscount;
    }

    public void setImageDiscount(String imageDiscount) {
        this.imageDiscount = imageDiscount;
    }

    public void setNameDiscount(String nameDiscount) {
        this.nameDiscount = nameDiscount;
    }

    public String getDescribeDiscount() {
        return describeDiscount;
    }

    public void setDescribeDiscount(String describeDiscount) {
        this.describeDiscount = describeDiscount;
    }

    public Double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(Double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        //Chưa có thuộc tính cần Custom Validate!
    }
}
