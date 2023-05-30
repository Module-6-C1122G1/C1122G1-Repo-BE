package com.example.dncinema.service.show_room;

import com.example.dncinema.model.Seat;

import java.util.List;

public interface ISeatServiceLanhNM {
    List<Seat> findAllListSeatByIdShowRoom(Integer id);
    void updateStatusSeatByIdShowRoom(Integer id);
    void resetStatusSeatByIdShowRoom(Integer id);
}
