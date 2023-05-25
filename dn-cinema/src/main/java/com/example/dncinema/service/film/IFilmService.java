package com.example.dncinema.service.film;

import com.example.dncinema.model.Film;

public interface IFilmService {
    Film save(Film film);
    Film updateFilm(Film film);
}
