package com.example.dncinema.dto;

import com.example.dncinema.model.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TicketDTO {

    @Valid
    private Integer IdCustomer;

    private Integer idFilm;
    private Integer[] listSeat;
    private Discount discount;
    private long price;

    public TicketDTO() {
    }

    public TicketDTO(Integer idCustomer, Integer idFilm, Integer[] listSeat, Discount discount, long price) {
        IdCustomer = idCustomer;
        this.idFilm = idFilm;
        this.listSeat = listSeat;
        this.discount = discount;
        this.price = price;
    }

    public Integer getIdCustomer() {
        return IdCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        IdCustomer = idCustomer;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
