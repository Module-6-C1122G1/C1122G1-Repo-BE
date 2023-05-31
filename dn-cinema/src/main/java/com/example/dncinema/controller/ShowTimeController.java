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
@RequestMapping("/api/public/showtime")
@CrossOrigin("*")
public class ShowTimeController {
    @Autowired
    private IShowTimeService showTimeService;

    /**
     * @param id
     * @return ResponseEntity<>(showTimes, HttpStatus.OK)
     * @author HaiPH
     * @Usage_method Returns all showtimes by idFilm in the database
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<ShowTime>> getAllDateByIdFilm(@PathVariable Integer id) {
        List<ShowTime> showTimes = showTimeService.findAllDateByIdFilm(id);
        if (showTimes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(showTimeService.findAllDateByIdFilm(id), HttpStatus.OK);
    }

    /**
     * @param id
     * @param showDate
     * @return ResponseEntity<>(ListShowTime, HttpStatus.OK)
     * @author HaiPH
     * @Usage_method Returns all showtimes by idFilm and showDate in the database
     */
    @GetMapping("/{id}/{showDate}")
    public ResponseEntity<List<ShowTime>> getAllTimeByIdFilmAndShowDate(@PathVariable Integer id, @PathVariable String showDate) {
        List<ShowTime> showTimes = showTimeService.findAllTimeByIdFilmAndShowDate(id, showDate);
        if (showTimes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(showTimeService.findAllTimeByIdFilmAndShowDate(id, showDate), HttpStatus.OK);
    }
}
