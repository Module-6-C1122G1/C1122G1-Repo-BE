package com.example.dncinema.service.show_room.impl;

import com.example.dncinema.model.Seat;
import com.example.dncinema.repository.show_room.ISeatRepository;
import com.example.dncinema.service.show_room.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatService implements ISeatService {
    @Autowired
    private ISeatRepository iSeatRepository;
    @Override
    public List<Seat> findAllSeat() {
        return iSeatRepository.findAll();
    }
}
