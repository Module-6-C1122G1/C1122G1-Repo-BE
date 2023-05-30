package com.example.dncinema.controller.show_room;

import com.example.dncinema.model.Seat;
import com.example.dncinema.repository.show_room.ISeatRepository;
import com.example.dncinema.service.show_room.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ISeatRepository iSeatRepository;


    @GetMapping("/list/{id}")
    public ResponseEntity<List<Seat>> getAllListSeatByIdShowRoom(@PathVariable Integer id){
        return new ResponseEntity<>(iSeatRepository.findByShowRoom_IdShowRoom(id), HttpStatus.OK);
    }

    @PutMapping("/update_status")
    public ResponseEntity<?> updateStatusSeatByIdShowRoom(@RequestBody String[] listId) {
        for (String id : listId) {
            iSeatService.updateStatusSeatByIdShowRoom(Integer.parseInt(id));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/reset_status")
    public ResponseEntity<?> resetStatusSeatByIdShowRoom(@RequestBody String[] listId) {
        for (String id : listId) {
            iSeatService.resetStatusSeatByIdShowRoom(Integer.parseInt(id));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
