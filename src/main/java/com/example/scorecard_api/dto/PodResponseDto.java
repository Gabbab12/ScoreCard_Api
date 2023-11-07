package com.example.scorecard_api.dto;

import com.example.scorecard_api.model.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PodResponseDto {
    private  String podName;
    private List<Admin> admin = new ArrayList<>();
}
