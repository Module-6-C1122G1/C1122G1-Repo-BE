package com.example.dncinema.service.movie;

import com.example.dncinema.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMovieService {
    Page<Film> findAllFilm(String search, Pageable pageable);

    /**
     * @param id
     * @return findFilmById
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @Usage_method findById to show detail film
     */
    Film findFilmById(Integer id);

    List<Film> findAllListFilm();

}
