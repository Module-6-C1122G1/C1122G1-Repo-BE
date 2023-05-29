package com.example.dncinema.dto.discount;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import javax.validation.constraints.NotBlank;

public class DiscountDTO implements Validator {
    private int idDiscount;
    @NotBlank(message = "Tên khuyến mãi không được để trống")
    @Length(max = 255,message = "Tên khuyến mãi không dài quá 255 từ")
    private String nameDiscount;
    @NotBlank(message = "Cannot be left blank")
    private String imageDiscount;
    @NotBlank(message = "Describe cannot be left blank")
    @NotNull(message = "Ngày bắt đầu không được để trống")
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private String dateStart;
    @NotNull(message = "Ngày kết thúc không được để trống")
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private String dateEnd;
    @NotBlank(message = "Chi tiết khuyến mãi không được để trống")
    private String describeDiscount;
    @NotNull(message = "Phần trăm giảm giá không được để trống")
    @Max(value = 100,message = "Phần trăm giảm giá không được quá 100")
    @DecimalMin(value = "0.0", inclusive = false,message = "Phần trăm giảm giá phải lớn hơn 0")
    private Double percentDiscount;

    public DiscountDTO() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
