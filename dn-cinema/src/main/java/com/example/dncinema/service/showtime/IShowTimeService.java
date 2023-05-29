package com.example.dncinema.service.showtime;

import com.example.dncinema.model.ShowTime;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IShowTimeService {
    List<ShowTime> findAllDateByIdFilm(Integer id);
    List<ShowTime> findAllTimeByIdFilmAndShowDate(Integer id, String showDate);
}
