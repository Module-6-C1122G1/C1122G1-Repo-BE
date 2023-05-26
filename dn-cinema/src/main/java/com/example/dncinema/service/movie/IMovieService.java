package com.example.dncinema.service.movie;

import com.example.dncinema.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMovieService {
    Page<Film> findAllFilm(String search, Pageable pageable);

    Film findFilmById(Integer id);
    List<Film> findAllListFilm();
}
