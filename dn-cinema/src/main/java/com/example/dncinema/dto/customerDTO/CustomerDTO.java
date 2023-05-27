package com.example.dncinema.dto.customerDTO;

import com.example.dncinema.model.AccountUser;
import com.example.dncinema.model.TypeCustomer;

import javax.validation.constraints.*;

public class CustomerDTO {
    private Integer idCustomer;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(?=.*[a-zA-Z\\s])[^!@#$%^&*(),.?\":{}|<>]{4,100}$", message = "Tên không hợp lệ")
    @Size(min = 4, max = 99, message = "Tên phải có độ dài từ 4 đến 99 ký tự")
    private String nameCustomer;
    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "điểm phải lớn hơn 0")
    private Double pointCustomer;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(nam|nữ)$", message = "Giới tính phải là 'nam' hoặc 'nữ'")
    private String gender;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(\\+?84|0)(3[2-9]|5[2689]|7[06-9]|8[1-9]|9[0-9])[0-9]{7}$",
            message = "Số điện thoại không hợp lệ")
    private String phone;
    @NotBlank(message = "Không được để trống")
    @Size(min = 3, max = 200, message = "địa chỉ phải từ 3 ký tự và không dài quá 200 ký tự")
    private String address;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email không hợp lệ")
    private String email;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^\\d{9}$", message = "Số CMND không hợp lệ, bắt buộc phải là 9 chữ số")
    private String identityCard;
    private TypeCustomer typeCustomer;
    private AccountUser accountUser;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer idCustomer, String nameCustomer, Double pointCustomer, String gender, String phone, String address,
                       String email, String identityCard, TypeCustomer typeCustomer, AccountUser accountUser) {
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
