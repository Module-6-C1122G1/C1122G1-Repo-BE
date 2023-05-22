package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "information_ticket")
public class InformationTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_information_ticket")
    private Integer idInformationTicket;

    @ManyToOne
    @JoinColumn(name = "id_ticket")
    private Ticket ticket;


    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film film;


    @ManyToOne
    @JoinColumn(name = "id_show_room")
    private ShowRoom showRoom;


    @ManyToOne
    @JoinColumn(name = "id_show_time")
    private ShowTime showTime;

    public InformationTicket() {
    }

    public InformationTicket(Ticket ticket, Film film, ShowRoom showRoom, ShowTime showTime) {
        this.ticket = ticket;
        this.film = film;
        this.showRoom = showRoom;
        this.showTime = showTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public ShowRoom getShowRoom() {
        return showRoom;
    }

    public void setShowRoom(ShowRoom showRoom) {
        this.showRoom = showRoom;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }
}
