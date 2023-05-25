package com.example.dncinema.controller.film;

import com.example.dncinema.dto.FilmDTO;
import com.example.dncinema.model.Film;
import com.example.dncinema.model.ShowTime;
import com.example.dncinema.model.TypeFilm;
import com.example.dncinema.service.film.IFilmService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/film")
public class FilmController {
    private final IFilmService iFilmService;

    public FilmController(IFilmService iFilmService) {
        this.iFilmService = iFilmService;
    }

    /**
     * @Author: AnhNQ
     * @param filmDTO
     * @param bindingResult
     * @return HttpStatus.OK, newFilm
     */
    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> createFilm(@RequestBody @Valid FilmDTO filmDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.NOT_ACCEPTABLE);
        }
        Film film = new Film();
        BeanUtils.copyProperties(filmDTO,film);
        TypeFilm typeFilm = new TypeFilm();
        ShowTime showTime = new ShowTime();
        typeFilm.setIdTypeFilm(filmDTO.getTypeFilm().getIdTypeFilm());
        showTime.setIdShowTime(filmDTO.getShowTime().getIdShowTime());
        iFilmService.save(film);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @Author AnhNQ
     * @param idFilm
     * @param film
     * @return newFilm, HttpStatus.OK
     */
    @PutMapping("/{idFilm}")
    @ResponseBody
    public ResponseEntity<Film> updateProduct(@PathVariable int idFilm, @RequestBody Film film) {
        Optional<Film> filmOptional = iFilmService.findById(idFilm);
        if (!filmOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        film.setIdFilm(filmOptional.get().getIdFilm());
        return new ResponseEntity<>(iFilmService.updateFilm(film), HttpStatus.OK);
    }
}
