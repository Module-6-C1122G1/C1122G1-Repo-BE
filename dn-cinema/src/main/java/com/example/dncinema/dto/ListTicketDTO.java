package com.example.dncinema.dto;

import java.time.LocalDate;

public class ListTicketDTO {
    private int id_ticket;
    private int id_customer;
    private String name_customer;
    private String phone;
    private String identity_card;
    private String name_film;
    private LocalDate show_date;
    private String show_time;
    private Boolean is_delete;

    public ListTicketDTO() {
    }

    public ListTicketDTO(int id_ticket, int id_customer, String name_customer, String phone, String identity_card, String name_film, LocalDate show_date, String show_time) {
        this.id_ticket = id_ticket;
        this.id_customer = id_customer;
        this.name_customer = name_customer;
        this.phone = phone;
        this.identity_card = identity_card;
        this.name_film = name_film;
        this.show_date = show_date;
        this.show_time = show_time;
    }

    public ListTicketDTO(int id_ticket, int id_customer, String name_customer, String phone, String identity_card, String name_film, LocalDate show_date, String show_time, Boolean is_delete) {
        this.id_ticket = id_ticket;
        this.id_customer = id_customer;
        this.name_customer = name_customer;
        this.phone = phone;
        this.identity_card = identity_card;
        this.name_film = name_film;
        this.show_date = show_date;
        this.show_time = show_time;
        this.is_delete = is_delete;
    }

    public Boolean getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Boolean is_delete) {
        this.is_delete = is_delete;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(String identity_card) {
        this.identity_card = identity_card;
    }

    public String getName_film() {
        return name_film;
    }

    public void setName_film(String name_film) {
        this.name_film = name_film;
    }

    public LocalDate getShow_date() {
        return show_date;
    }

    public void setShow_date(LocalDate show_date) {
        this.show_date = show_date;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

}
