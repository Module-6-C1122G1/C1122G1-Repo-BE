package com.example.dncinema.service.showtime.impl;

import com.example.dncinema.model.ShowTime;
import com.example.dncinema.repository.showtime.IShowTimeRepository;
import com.example.dncinema.service.showtime.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeService implements IShowTimeService {
    @Autowired
    IShowTimeRepository showTimeRepository;
    @Override
    public List<ShowTime> findAllDateByIdFilm(Integer id) {
        return showTimeRepository.findAllDateByIdFilm(id);
    }

    @Override
    public List<ShowTime> findAllTimeByIdFilmAndShowDate(Integer id, String showDate) {
        return showTimeRepository.findAllDateByIdFilmAndShowDate(id,showDate);
    }
}
