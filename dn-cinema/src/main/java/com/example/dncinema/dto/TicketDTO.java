package com.example.dncinema.dto;

import com.example.dncinema.model.*;

public class TicketDTO {
    private Customer customer;
    private Film film;
    private Integer[] listSeat;
    private Discount discount;
    private long price;

    public TicketDTO() {
    }

    public TicketDTO(Customer customer, Film film, Integer[] listSeat, Discount discount, long price) {
        this.customer = customer;
        this.film = film;
        this.listSeat = listSeat;
        this.discount = discount;
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Integer[] getListSeat() {
        return listSeat;
    }

    public void setListSeat(Integer[] listSeat) {
        this.listSeat = listSeat;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
