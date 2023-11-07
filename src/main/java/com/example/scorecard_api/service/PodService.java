

package com.example.scorecard_api.service;


import com.example.scorecard_api.dto.PodRequestDto;
import com.example.scorecard_api.dto.PodResponseDto;

public interface PodService {
    PodResponseDto createPod(Long id, PodRequestDto requestDto);

    PodRequestDto updatePod(Long id, PodRequestDto requestDto);
}