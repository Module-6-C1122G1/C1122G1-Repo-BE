package com.example.dncinema.service.film.impl;

import com.example.dncinema.model.Film;
import com.example.dncinema.repository.film.IFilmRepository;
import com.example.dncinema.service.film.IFilmService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmService implements IFilmService {
    private final IFilmRepository iFilmRepository;

    public FilmService(IFilmRepository iFilmRepository) {
        this.iFilmRepository = iFilmRepository;
    }

//    @Override
//    public Film save(Film film) {
//        return iFilmRepository.save(film);
//    }

//    @Override
//    public void createFilm(Film film) {
//       iFilmRepository.insertFilm(film);
//    }

    @Override
    public Film updateFilm(Film film) {
        return iFilmRepository.save(film);
    }


    @Override
    public Optional<Film> findById(Integer idFilm) {
        return iFilmRepository.findFilmByIdFilm(idFilm);
    }

    @Override
    public void save(Film film) {
        iFilmRepository.save(film);
    }




}
