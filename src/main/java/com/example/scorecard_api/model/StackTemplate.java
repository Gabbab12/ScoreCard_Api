package com.example.scorecard_api.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class StackTemplate  extends BaseClass{
    private String stackName;
}
