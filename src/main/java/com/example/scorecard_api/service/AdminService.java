package com.example.scorecard_api.service;



import com.example.scorecard_api.dto.DecadevDto;
import com.example.scorecard_api.dto.WeeklyScoreDto;
import com.example.scorecard_api.dto.responsedto.APIResponse;
import com.example.scorecard_api.model.Decadev;
import com.example.scorecard_api.model.WeeklyScore;
import com.example.scorecard_api.response.AdminResponse;

import java.util.List;


public interface AdminService {
    List<AdminResponse> getAllAdmin();

    WeeklyScore decadevWeeklyScore(WeeklyScoreDto weeklyScoreDto, Long id);

   void deleteDecadev(Long decadevId);

    WeeklyScore updateDecadevWeeklyScore(WeeklyScoreDto score, Long Id, Long weekId);


    String createDecadev(DecadevDto dev, Long podId, Long stackId, Long squadId);
    APIResponse<Decadev> updateDecadev(DecadevDto decadevDto, Long decadevId, Long podId, Long stackId, Long squadId);

    WeeklyScore getDevWeeklyScore(String week, Long id);
    List<DecadevDto> getAllDecadevsFromAPod(Long podId);
}
