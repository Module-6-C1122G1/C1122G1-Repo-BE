package com.example.dncinema.service.impl;

import com.example.dncinema.dto.StatisticsDTO;
import com.example.dncinema.repository.IStatisticsRepository;
import com.example.dncinema.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService implements IStatisticsService {

    @Autowired
    private IStatisticsRepository repository;
    @Override
    public StatisticsDTO findCommentSummaryByTitle() {
        return repository.findCommentSummaryByTitle();
    }

}
