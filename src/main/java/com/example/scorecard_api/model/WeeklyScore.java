package com.example.scorecard_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeeklyScore extends BaseClass {
    private double algorithmScore;
    private double weeklyAssessment;
    private double qaTest;
    private double agileTest;
    private double weeklyTask;
    private double cumulativeScore;
    private String week;
    @ManyToOne
    @JoinColumn(name ="decadev_id", referencedColumnName = "id")
    @JsonBackReference
    private Decadev decadev;


}
