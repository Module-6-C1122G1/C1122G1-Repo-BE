package com.example.dncinema.controller;

import com.example.dncinema.model.Film;
import com.example.dncinema.service.movie.IMovieService;
import com.example.dncinema.service.typeFilm.ITypeFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieController {
    @Autowired
    private IMovieService movieService;
    @Autowired
    private ITypeFilmService iTypeFilmService;

    @GetMapping
    public Page<Film> findAllFilm(@PageableDefault(size = 4) Pageable pageable,
                                  @RequestParam(required = false, defaultValue = "") String search) {
        Page<Film> films = movieService.findAllFilm(search, pageable);
        List<Film> filmList = films.toList();
        return new PageImpl<>(filmList, pageable, films.getTotalElements());
    }

    @GetMapping("/{id}")
    public Film findFilmById(@PathVariable Integer id) {
        return movieService.findFilmById(id);
    }

    /**
     * Create: QuynhHTN
     * Date create: 24/05/2023
     * @param idFilm
     * @param model
     * @return detail
     */
    @GetMapping("/detail/{idFilm}")
    public String detail(@PathVariable Integer idFilm, Model model) {
        model.addAttribute("typeFilmList", iTypeFilmService.findAll());
        model.addAttribute("film", movieService.findFilmById(idFilm));
        return "detail";
    }
}
