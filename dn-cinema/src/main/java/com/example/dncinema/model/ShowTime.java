package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "show_time")
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_show_time")
    private Integer idShowTime;
    @Column(name = "name_show_time", columnDefinition = "varchar(45)")
    private String nameShowTime;

    public ShowTime() {
    }

    public ShowTime(Integer idShowTime, String nameShowTime) {
        this.idShowTime = idShowTime;
        this.nameShowTime = nameShowTime;
    }

    public Integer getIdShowTime() {
        return idShowTime;
    }

    public void setIdShowTime(Integer idShowTime) {
        this.idShowTime = idShowTime;
    }

    public String getNameShowTime() {
        return nameShowTime;
    }

    public void setNameShowTime(String nameShowTime) {
        this.nameShowTime = nameShowTime;
    }
}
