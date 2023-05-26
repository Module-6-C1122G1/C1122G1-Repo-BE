package com.example.dncinema.service;

import com.example.dncinema.dto.StatisticsDTO;

public interface IStatisticsService {
    StatisticsDTO findCommentSummaryByTitle();
}
