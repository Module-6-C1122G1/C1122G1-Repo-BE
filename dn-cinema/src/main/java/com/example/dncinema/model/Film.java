package com.example.dncinema.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Integer idFilm;
    @Column(name = "name_film", columnDefinition = "varchar(255)")
    private String nameFilm;
    @Column(name = "director", columnDefinition = "varchar(255)")
    private String director;
    @Column(name = "trailer", columnDefinition = "varchar(255)")
    private String trailer;
    @Column(name = "describe_film", columnDefinition = "varchar(255)")
    private String describeFilm;
    @Column(name = "actor", columnDefinition = "varchar(255)")
    private String actor;
    @Column(name = "normal_seat_price")
    private Double normalSeatPrice;
    @Column(name = "vip_seat_price")
    private Double vipSeatPrice;
    @Column(name = "date_start_film", columnDefinition = "date")
    private LocalDate dateStartFilm;
    @Column(name = "date_end_film", columnDefinition = "date")
    private LocalDate dateEndFilm;
    @Column(name = "img_film", columnDefinition = "varchar(255)")
    private String imgFilm;
    @ManyToOne
    @JoinColumn(name = "id_type_film")
    private TypeFilm typeFilm;

    public Film() {
    }

    public Film(Integer idFilm, String nameFilm, String director, String trailer, String describeFilm, String actor, Double normalSeatPrice, Double vipSeatPrice, LocalDate dateStartFilm, LocalDate dateEndFilm, String imgFilm, TypeFilm typeFilm) {
        this.idFilm = idFilm;
        this.nameFilm = nameFilm;
        this.director = director;
        this.trailer = trailer;
        this.describeFilm = describeFilm;
        this.actor = actor;
        this.normalSeatPrice = normalSeatPrice;
        this.vipSeatPrice = vipSeatPrice;
        this.dateStartFilm = dateStartFilm;
        this.dateEndFilm = dateEndFilm;
        this.imgFilm = imgFilm;
        this.typeFilm = typeFilm;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDescribeFilm() {
        return describeFilm;
    }

    public void setDescribeFilm(String describeFilm) {
        this.describeFilm = describeFilm;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Double getNormalSeatPrice() {
        return normalSeatPrice;
    }

    public void setNormalSeatPrice(Double normalSeatPrice) {
        this.normalSeatPrice = normalSeatPrice;
    }

    public Double getVipSeatPrice() {
        return vipSeatPrice;
    }

    public void setVipSeatPrice(Double vipSeatPrice) {
        this.vipSeatPrice = vipSeatPrice;
    }

    public LocalDate getDateStartFilm() {
        return dateStartFilm;
    }

    public void setDateStartFilm(LocalDate dateStartFilm) {
        this.dateStartFilm = dateStartFilm;
    }

    public LocalDate getDateEndFilm() {
        return dateEndFilm;
    }

    public void setDateEndFilm(LocalDate dateEndFilm) {
        this.dateEndFilm = dateEndFilm;
    }

    public String getImgFilm() {
        return imgFilm;
    }

    public void setImgFilm(String imgFilm) {
        this.imgFilm = imgFilm;
    }

    public TypeFilm getTypeFilm() {
        return typeFilm;
    }

    public void setTypeFilm(TypeFilm typeFilm) {
        this.typeFilm = typeFilm;
    }

}
