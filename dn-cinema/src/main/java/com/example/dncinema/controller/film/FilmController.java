package com.example.dncinema.controller.film;

import com.example.dncinema.dto.FilmDTO;
import com.example.dncinema.dto.TypeFilmDTO;
import com.example.dncinema.model.Film;
import com.example.dncinema.model.ShowTime;
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
     * @DateCreated  25/05/2023
     * @param filmDTO
     * @param bindingResult
     * @return HttpStatus.OK, newFilm
     */
    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> createFilm(@Valid @RequestBody  FilmDTO filmDTO, BindingResult bindingResult){
        if (filmDTO.getShowTime() == null || filmDTO.getTypeFilm() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.NOT_ACCEPTABLE);
        }
        Film film = new Film();
        BeanUtils.copyProperties(filmDTO,film);
        TypeFilmDTO typeFilmDTO = new TypeFilmDTO();
        ShowTime showTime = new ShowTime();
        typeFilmDTO.setIdTypeFilm(filmDTO.getTypeFilm().getIdTypeFilm());
        showTime.setIdShowTime(filmDTO.getShowTime().getIdShowTime());
        iFilmService.save(film);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @Author AnhNQ
     * @DateCreated  25/05/2023
     * @param idFilm
     * @param filmDTO
     * @return film, HttpStatus.OK
     */
    @PutMapping("/{idFilm}")
    @ResponseBody
    public ResponseEntity<List<FieldError>> updateFilm(@Valid @RequestBody FilmDTO filmDTO, @PathVariable("idFilm") int idFilm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.NOT_ACCEPTABLE);
        }
        Optional<Film> filmOptional = iFilmService.findById(idFilm);
        Film film = new Film();
        BeanUtils.copyProperties(filmOptional,filmDTO);
        System.out.println(filmDTO.getIdFilm());
        BeanUtils.copyProperties(filmDTO,film);
        TypeFilmDTO typeFilmDTO = new TypeFilmDTO();
        ShowTime showTime = new ShowTime();
        typeFilmDTO.setIdTypeFilm(filmDTO.getTypeFilm().getIdTypeFilm());
        showTime.setIdShowTime(filmDTO.getShowTime().getIdShowTime());
        iFilmService.save(film);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
