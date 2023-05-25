package com.example.dncinema.service.film;

import com.example.dncinema.model.Film;

import java.util.Optional;

public interface IFilmService {
    void save(Film film);
    Film updateFilm(Film film);
    Optional<Film> findById(Integer idFilm);
}
