package com.example.scorecard_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "decadev")
@AllArgsConstructor
@NoArgsConstructor
public class Decadev extends User{

    private String decadevId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "squad_id", referencedColumnName = "id")
    private Squad squad;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "stack_id", referencedColumnName = "id")
    private Stack stack;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pod_id",referencedColumnName = "id")
    private Pod pod;

    @JsonBackReference
    @OneToMany(mappedBy = "decadev")
    private List<WeeklyScore> weeklyScores = new ArrayList<>();

}