package com.example.dncinema.controller;

import com.example.dncinema.model.Film;
import com.example.dncinema.model.ShowTime;
import com.example.dncinema.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/movie")
@CrossOrigin("*")
public class MovieController {
    @Autowired
    private IMovieService movieService;

    /**
     * @author TruongDM
     * @param pageable
     * @param search
     * @return ResponseEntity<>(films,HttpStatus.OK)
     * Phương thức sử dụng để tìm kiếm kết hợp xổ danh sách film
     */
    @GetMapping
    public ResponseEntity<?> findAllFilm(@PageableDefault(size = 4)Pageable pageable,
                                      @RequestParam(required = false, defaultValue = "")String search){
        Page<Film> films = movieService.findAllFilm(search,pageable);
        if (films.isEmpty()){
            return new ResponseEntity<>(films,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(films,HttpStatus.OK);
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
}
