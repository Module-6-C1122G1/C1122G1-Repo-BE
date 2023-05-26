package com.example.dncinema.service;

import com.example.dncinema.dto.StatisticsMemberDTO;

import java.util.List;

public interface IStatisticsMemberService {
    List<StatisticsMemberDTO> findCommentSummaryByTitleMember();
}
