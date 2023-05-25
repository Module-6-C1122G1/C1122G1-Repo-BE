package com.example.dncinema.service;

import com.example.dncinema.dto.TicketDTO;
import com.example.dncinema.model.Discount;

import java.io.UnsupportedEncodingException;

public interface ITicketServiceMinh {
    void saveTicket(TicketDTO ticketDTO) throws UnsupportedEncodingException;
    void sendEmail(String email, String path);
    Discount findDiscount(String nameDiscount);
    String pay(long amount) throws UnsupportedEncodingException;
    void createQR(String data, int a, String path);

}
