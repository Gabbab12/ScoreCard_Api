package com.example.scorecard_api.repository;

import com.example.scorecard_api.model.Decadev;
import com.example.scorecard_api.model.WeeklyScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeeklyScoreRepository extends JpaRepository<WeeklyScore,Long> {
    WeeklyScore findWeeklyScoreByWeekAndDecadev(String week, Decadev decadev);
    List<WeeklyScore> findWeeklyScoresByDecadev(Decadev decadev);
}
