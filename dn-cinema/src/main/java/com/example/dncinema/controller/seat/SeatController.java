package com.example.dncinema.controller.seat;

import com.example.dncinema.model.Seat;
import com.example.dncinema.model.ShowTime;
import com.example.dncinema.service.movie.IMovieService;
import com.example.dncinema.service.seat.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
@CrossOrigin("*")
public class SeatController {
    @Autowired
    private ISeatService seatService;

    /**
     * @author HaiPH
     * @param id
     * @return ResponseEntity<>(ListSeat, HttpStatus.OK)
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<Seat>> getAllListSeatByIdRoom(@PathVariable Integer id){
        return new ResponseEntity<>(seatService.findAllListSeatByIdRoom(id), HttpStatus.OK);
    }


}

