//package com.example.dncinema.service.film.impl;
//
//import com.example.dncinema.model.Film;
//import com.example.dncinema.repository.film.IFilmRepository;
//import com.example.dncinema.service.film.IFilmService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FilmService implements IFilmService {
//    private final IFilmRepository iFilmRepository;
//
//    public FilmService(IFilmRepository iFilmRepository) {
//        this.iFilmRepository = iFilmRepository;
//    }
//
////    @Override
////    public void save(Film film) {
////        iFilmRepository.insertFilm(film.getActor(), film.getDateEndFilm(), film.getDateStartFilm(),film.getDescribeFilm(),film.getDirector(),film.getImgFilm(),film.getMovieLabel(),film.getNameFilm(),film.getNormalSeatPrice(),film.getStudioFilm(),film.getTimeFilm(),film.getTrailer(),film.getVipSeatPrice(),film.getShowTime().getIdShowTime(), film.getTypeFilm().getIdTypeFilm());
////    }
//
//    @Override
//    public Film save(Film film) {
//        return iFilmRepository.save(film);
//    }
//
//    @Override
//    public void updateFilm(Film film) {
//        iFilmRepository.updateFilm(film);
//    }
//}
