package com.example.dncinema.controller.seat;

import com.example.dncinema.model.Seat;
import com.example.dncinema.model.ShowTime;
import com.example.dncinema.repository.seat.ISeatRepository;
import com.example.dncinema.service.movie.IMovieService;
import com.example.dncinema.service.seat.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/seat")
@CrossOrigin("*")
public class SeatController {
    @Autowired
    private ISeatService seatService;
    @Autowired
    private ISeatRepository iSeatRepository;

    /**
     * @param id
     * @return ResponseEntity<>(seats, HttpStatus)
     * @author HaiPH
     * @Usage_method Returns all seats by idShowTime in the database
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<Seat>> getAllListSeatByIdShowTime(@PathVariable Integer id) {
        List<Seat> seats = seatService.findAllListSeatByIdShowTime(id);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    /**
     * @param listId
     * @return ResponseEntity<>(HttpStatus.OK)
     * @author HaiPH
     * @Usage_method Update available seats to unavailable status
     */
    @PutMapping("/update_status")
    public ResponseEntity<?> updateStatusSeatByIdShowTime(@RequestBody String[] listId) {
        for (String id : listId) {
            seatService.updateStatusSeatByIdShowTime(Integer.parseInt(id));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/reset_status")
    public ResponseEntity<?> resetStatusSeatByIdShowTime(@RequestBody String[] listId) {
        for (String id : listId) {
            seatService.resetStatusSeatByIdShowTime(Integer.parseInt(id));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @author MinhNV
     * @param idSeat
     * @return
     */
    @GetMapping("/check-seat/{idSeat}")
    public ResponseEntity<?> checkSeat(@PathVariable Integer idSeat) {
        Seat seat = iSeatRepository.getByIdSeat(idSeat);
        return new ResponseEntity<>(seat.getSeat().getIdStatusSeat(),HttpStatus.OK);
    }
}

