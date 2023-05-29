package com.example.dncinema.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_discount")
    private Integer idDiscount;
    @Column(name = "name_discount", columnDefinition = "varchar(255)")
    private String nameDiscount;
    @Column(name = "date_start", columnDefinition = "varchar(255)")
    private String dateStart;
    @Column(name = "date_end", columnDefinition = "varchar(255)")
    private String dateEnd;
    @Column(name = "img", columnDefinition = "varchar(255)")
    private String img;
    @Column(name = "describe_discount", columnDefinition = "varchar(255)")
    private String describeDiscount;
    @Column(name = "percent_discount")
    private Double percentDiscount;


    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    public Discount() {
    }

    public Discount(Integer idDiscount, String nameDiscount, String dateStart, String dateEnd, String describeDiscount, Double percentDiscount, boolean isDeleted) {
        this.idDiscount = idDiscount;
        this.nameDiscount = nameDiscount;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.describeDiscount = describeDiscount;
        this.percentDiscount = percentDiscount;
        this.isDeleted = isDeleted;
    }

    public Integer getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(Integer idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getNameDiscount() {
        return nameDiscount;
    }

    public void setNameDiscount(String nameDiscount) {
        this.nameDiscount = nameDiscount;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
