package com.example.dncinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "show_time")
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_show_time")
    private Integer idShowTime;
    @Column(name = "show_date", columnDefinition = "date")
    private LocalDate showDate;
    @Column(name = "show_time", columnDefinition = "varchar(255)")
    private String showTime;

    @ManyToOne
    @JoinColumn(name = "id_show_room")
    private ShowRoom showRoom;
    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film film;
    public ShowTime() {
    }

    public ShowTime(Integer idShowTime, LocalDate showDate, String showTime, ShowRoom showRoom) {
        this.idShowTime = idShowTime;
        this.showDate = showDate;
        this.showTime = showTime;
        this.showRoom = showRoom;

    }

    public Integer getIdShowTime() {
        return idShowTime;
    }

    public void setIdShowTime(Integer idShowTime) {
        this.idShowTime = idShowTime;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public ShowRoom getShowRoom() {
        return showRoom;
    }

    public void setShowRoom(ShowRoom showRoom) {
        this.showRoom = showRoom;
    }


}
