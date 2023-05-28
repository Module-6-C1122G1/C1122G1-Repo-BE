package com.example.dncinema.service.seat;

import com.example.dncinema.model.Film;
import com.example.dncinema.model.Seat;

import java.util.List;

public interface ISeatService {
    List<Seat> findAllListSeatByIdRoom(Integer id);
}
