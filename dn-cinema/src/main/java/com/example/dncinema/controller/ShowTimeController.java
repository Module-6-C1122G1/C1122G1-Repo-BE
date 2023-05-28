package com.example.dncinema.controller;

import com.example.dncinema.model.Film;
import com.example.dncinema.model.ShowTime;
import com.example.dncinema.service.showtime.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/showtime")
@CrossOrigin("*")
public class ShowTimeController {
    @Autowired
    IShowTimeService showTimeService;

    /**
     * @author HaiPH
     * @param id
     * @return ResponseEntity<>(ListShowTime, HttpStatus.OK)
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<ShowTime>> getAllDateByIdFilm(@PathVariable Integer id){
        return new ResponseEntity<>(showTimeService.findAllDateByIdFilm(id), HttpStatus.OK);
    }

    /**
     * @author HaiPH
     * @param id
     * @param showDate
     * @return ResponseEntity<>(ListShowTime, HttpStatus.OK)
     */
    @GetMapping("/{id}/{showDate}")
    public ResponseEntity<List<ShowTime>> getAllTimeByIdFilmAndShowDate(@PathVariable Integer id,@PathVariable String showDate){
        return new ResponseEntity<>(showTimeService.findAllTimeByIdFilmAndShowDate(id,showDate), HttpStatus.OK);
    }
}
