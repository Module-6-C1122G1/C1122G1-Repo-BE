package com.example.dncinema.controller;

import com.example.dncinema.dto.FilmDTO;
import com.example.dncinema.model.Film;
import com.example.dncinema.service.movie.IMovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/public/movie")
@CrossOrigin("*")
public class MovieController {
    @Autowired
    private IMovieService movieService;

    /**
     * @param pageable
     * @param search
     * @return ResponseEntity<>(films,HttpStatus.OK)
     * Phương thức sử dụng để tìm kiếm kết hợp xổ danh sách film
     * @author ChinhLV
     */
    @GetMapping
    public ResponseEntity<?> findAllFilm(@PageableDefault(size = 8) Pageable pageable,@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(required = false, defaultValue = "") String search) {
        pageable = PageRequest.of(page, 8);
        Page<Film> films = movieService.findAllFilm(search, pageable);
        if (films.isEmpty()) {
            return new ResponseEntity<>(films, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    /**
     * @Author QuynhHTN
     * @Param id
     * @Return new ResponseEntity<>
     * @Usage_method findById to show detail film
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> findFilmById(@PathVariable Integer id) {
        Film film = movieService.findFilmById(id);
        if (film == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(film, HttpStatus.OK);
    }


    /**
     * @param filmDTO
     * @param bindingResult
     * @return new ResponseEntity<>
     * @author AnhNQ
     * @dateCreated 29/05/2023
     * @Usage_method createFilm to create Film
     */
    @PostMapping("/create")
    public ResponseEntity<?> createFilm(@Valid @RequestBody FilmDTO filmDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Film film = new Film();
        BeanUtils.copyProperties(filmDTO, film);
        film.setTypeFilm(filmDTO.getTypeFilm());
        movieService.save(film);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /**
     * @param filmDTO
     * @param id
     * @param bindingResult
     * @return new ResponseEntity<>
     * @author AnhNQ
     * @dateCreated 29/05/2023
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFilm(@Valid @RequestBody FilmDTO filmDTO, @PathVariable Integer id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Film film = new Film();
        Optional<Film> filmOptional = movieService.findById(id);
        BeanUtils.copyProperties(filmOptional, filmDTO);
        filmDTO.setIdFilm(id);
        BeanUtils.copyProperties(filmDTO, film);
        film.setTypeFilm(filmDTO.getTypeFilm());
        movieService.save(film);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Film>> getAllFilms(){
        return new ResponseEntity<>(movieService.findAllListFilm(),HttpStatus.OK);
    }
    @GetMapping("/list-upcoming")
    public ResponseEntity<?> getAllFilmsUpcoming() {
        LocalDate now = LocalDate.now();
        return new ResponseEntity<>(movieService.findFilmsUpcoming(now), HttpStatus.OK);
    }
    @GetMapping("/list-playing")
    public ResponseEntity<?> getAllFilmsPlaying() {
        LocalDate now = LocalDate.now();
        return new ResponseEntity<>(movieService.findFilmsPlaying(now, now), HttpStatus.OK);
    }
}
