package com.example.dncinema.service;

import com.example.dncinema.dto.StatisticsDTO;

import java.util.List;

public interface IStatisticsService {
    List<StatisticsDTO> findCommentSummaryByTitle();
}
