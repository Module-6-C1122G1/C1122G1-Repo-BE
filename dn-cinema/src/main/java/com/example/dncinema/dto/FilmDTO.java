package com.example.dncinema.dto;

import com.example.dncinema.model.ShowTime;
import com.example.dncinema.model.TypeFilm;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class FilmDTO {
    private Integer idFilm;
    @NotBlank(message = "Tên phim không được để trống")
    @Length(max = 255)
    private String nameFilm;
    @NotBlank(message = "Đạo diễn không được để trống")
    @Length(max = 255)
    private String director;
    @NotBlank(message = "Hãng phim không được để trống")
    @Length(max = 255)
    private String studioFilm;
    @NotBlank(message = "Trailer không được để trống")
    @Length(max = 255)
    private String trailer;
    @NotBlank(message = "Nội dung phim không được để trống")
    private String describeFilm;
    @NotBlank(message = "Diễn viên không được để trống")
    @Length(max = 255)
    private String actor;
    @NotNull(message = "Giá ghế thường không được để trống")
    @Min(value = 0, message = "Giá ghế thường phải lớn hơn 0")
    private Double normalSeatPrice;
    @NotNull(message = "Giá ghế vip không được để trống")
    @Min(value = 0, message = "Giá ghế vip phải lớn hơn 0")
    private Double vipSeatPrice;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStartFilm;

    private LocalDate dateEndFilm;
    @NotBlank(message = "Ảnh phim không được để trống")
    private String imgFilm;
    @NotNull(message = "Thời lượng phim không được để trống")
    @Min(value = 0, message = "Thời lượng phim không được nhỏ hơn 0")
    private Integer timeFilm;
    @NotBlank(message = "Nhãn phim không được để trống")
    @Length(max = 255)
    private String movieLabel;
    private TypeFilm typeFilm;
    private ShowTime showTime;

    public FilmDTO() {
    }

    public FilmDTO(Integer idFilm, String nameFilm, String director, String studioFilm, String trailer, String describeFilm, String actor, Double normalSeatPrice, Double vipSeatPrice, LocalDate dateStartFilm, LocalDate dateEndFilm, String imgFilm, Integer timeFilm, String movieLabel, TypeFilm typeFilm, ShowTime showTime) {
        this.idFilm = idFilm;
        this.nameFilm = nameFilm;
        this.director = director;
        this.studioFilm = studioFilm;
        this.trailer = trailer;
        this.describeFilm = describeFilm;
        this.actor = actor;
        this.normalSeatPrice = normalSeatPrice;
        this.vipSeatPrice = vipSeatPrice;
        this.dateStartFilm = dateStartFilm;
        this.dateEndFilm = dateEndFilm;
        this.imgFilm = imgFilm;
        this.timeFilm = timeFilm;
        this.movieLabel = movieLabel;
        this.typeFilm = typeFilm;
        this.showTime = showTime;
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

    public String getStudioFilm() {
        return studioFilm;
    }

    public void setStudioFilm(String studioFilm) {
        this.studioFilm = studioFilm;
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

    public Integer getTimeFilm() {
        return timeFilm;
    }

    public void setTimeFilm(Integer timeFilm) {
        this.timeFilm = timeFilm;
    }

    public String getMovieLabel() {
        return movieLabel;
    }

    public void setMovieLabel(String movieLabel) {
        this.movieLabel = movieLabel;
    }

    public TypeFilm getTypeFilm() {
        return typeFilm;
    }

    public void setTypeFilm(TypeFilm typeFilm) {
        this.typeFilm = typeFilm;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }
}
