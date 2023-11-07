package com.example.scorecard_api.dto.responsedto;

import lombok.Data;

@Data
public class StackResponseDto {
    private String stackName;
    private Integer podCount;
    private String podsHealth;
}
