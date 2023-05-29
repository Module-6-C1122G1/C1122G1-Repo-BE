package com.example.dncinema.service.show_room;

import com.example.dncinema.model.Seat;
import com.example.dncinema.model.StatusSeat;

import java.util.List;

public interface ISeatService {
    List<Seat> findAllListSeatByIdShowRoom(Integer id);
    void updateStatusSeatByIdShowRoom(Integer id);
    void resetStatusSeatByIdShowRoom(Integer id);
}
