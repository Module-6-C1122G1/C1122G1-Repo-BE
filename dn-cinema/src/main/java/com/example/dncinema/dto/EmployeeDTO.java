package com.example.dncinema.dto;

import com.example.dncinema.model.AccountUser;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeDTO {
    private Integer idEmployee;
    @Pattern(regexp = "^(([a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*)([a-zA-Z\\s\\'ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*)([a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]))*$" , message = "Không chứa kí tự số và kí tự đặc biệt")
    @NotBlank(message = "Không được để trống")
    private String nameEmployee;
    @Size(min = 10 , max = 11)
    @Pattern(regexp = "^[+]?[0-9]{1,3}[-\\s]?[(]?[0-9]{1,4}[)]?[-\\s]?[0-9]{1,4}[-\\s]?[0-9]{1,9}$" , message = "Nhập không đúng định dạng số điện thoại")
    @NotBlank(message = "Không được để trống")
    private String phone;
    @Pattern(regexp = "^(([a-zA-Z\\sÀÁÂÃÈ ÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*)([a-zA-Z\\s\\'ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠà áâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*)([a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]))*$" , message = "Không chứa kí tự số và kí tự đặc biệt")

    @NotBlank(message = "Không được để trống")
    private String address;
    @NotBlank(message = "Không được để trống")
    private String gender;
    @NotBlank(message = "Không được để trống")
    private String dateOfBirth;
    @NotBlank(message = "Không được để trống")
    private String imgEmployee;
    @Size(min = 16 , max = 32)
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$" , message = "Nhập không đúng định dạng email")
    @NotBlank(message = "Không được để trống")
    private String email;
    @Size(min = 12 , max = 12)
    @Pattern(regexp = "^[0-9]{12}$" , message = "Nhập không đúng định dạng CCCD")
    @NotBlank(message = "Không được để trống")
    private String identityCard;
    private AccountUser accountUser;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer idEmployee, String nameEmployee, String phone, String address, String gender, String dateOfBirth, String imgEmployee, String email, String identityCard, AccountUser accountUser) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
