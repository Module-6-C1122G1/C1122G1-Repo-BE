package com.example.dncinema.controller.show_room;

import com.example.dncinema.dto.ShowRoomDTO;
import com.example.dncinema.model.Seat;
import com.example.dncinema.service.show_room.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/seat")
@CrossOrigin("*")
public class SeatController {
    @Autowired
    private ISeatService iSeatService;

    @GetMapping("/list")
    public List<Seat> list() {
        List<Seat> listSeat = iSeatService.findAllSeat();
        if (listSeat.isEmpty()) {
            return new ResponseEntity<>(listSeat, HttpStatus.BAD_REQUEST).getBody();
        }
        return new ResponseEntity<>(listSeat, HttpStatus.OK).getBody();
    }
}
