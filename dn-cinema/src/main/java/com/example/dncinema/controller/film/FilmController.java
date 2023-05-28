//package com.example.dncinema.controller.film;
//
//import com.example.dncinema.model.Film;
//import com.example.dncinema.service.film.IFilmService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/api/film")
//public class FilmController {
//    private final IFilmService iFilmService;
//
//    public FilmController(IFilmService iFilmService) {
//        this.iFilmService = iFilmService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Film> createFilm(@RequestBody Film film){
//        return new ResponseEntity<>(iFilmService.save(film), HttpStatus.OK);
//    }
//}
