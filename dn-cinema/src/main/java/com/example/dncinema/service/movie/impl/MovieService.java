
package com.example.dncinema.service.movie.impl;

import com.example.dncinema.dto.FilmDTO;
import com.example.dncinema.model.Film;
import com.example.dncinema.repository.IMovieRepository;
import com.example.dncinema.service.movie.IMovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;


@Service
public class MovieService implements IMovieService {
    @Autowired
    private IMovieRepository movieRepository;


    @Override
    public Page<FilmDTO> findAllFilm(String search, Pageable pageable) {
        Page<Film> filmPage = movieRepository.findAllFilm(search, pageable);
        List<FilmDTO> showRoomDTOList = new ArrayList<>();
        FilmDTO filmDTO;
        for (Film film : filmPage) {
            filmDTO = new FilmDTO();
            BeanUtils.copyProperties(film, filmDTO);
            showRoomDTOList.add(filmDTO);
        }
        return new PageImpl<>(showRoomDTOList, pageable, filmPage.getTotalElements());
    }

    /**
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @param id
     * @return findFilmById
     * @Usage_method findById to show detail film
     */
    @Override
    public Film findFilmById(Integer id) {
        return movieRepository.findFilmById(id);
    }

    @Override

    public Optional<Film> findById(Integer idFilm) {
        return movieRepository.findById(idFilm);
    }

    @Override
    public void save(Film film) {
        movieRepository.save(film);
    }



    public List<Film> findAllListFilm() {
        return movieRepository.findAllListFilm();
    }

    @Override
    public void deleteFilm(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Film> findFilmsUpcoming(LocalDate localDate) {
        return movieRepository.findFilmsByDateStartFilmGreaterThan(localDate);
    }

    @Override
    public List<Film> findFilmsPlaying(LocalDate localDate, LocalDate localDate2) {
        return movieRepository.findFilmsByDateStartFilmLessThanAndDateEndFilmGreaterThan(localDate, localDate2);
    }
}

