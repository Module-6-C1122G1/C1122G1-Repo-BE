package com.example.dncinema.service.movie;

import com.example.dncinema.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
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


    Optional<Film> findById(Integer idFilm);
    void save(Film film);

    List<Film> findAllListFilm();
    List<Film> findFilmsUpcoming(LocalDate localDate);
    List<Film> findFilmsPlaying(LocalDate localDate, LocalDate localDate2);
}
