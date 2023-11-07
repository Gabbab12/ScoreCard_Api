package com.example.scorecard_api.controller;


import com.example.scorecard_api.dto.PodRequestDto;
import com.example.scorecard_api.dto.PodResponseDto;
import com.example.scorecard_api.dto.responsedto.APIResponse;
import com.example.scorecard_api.service.PodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class PodController {
    private final PodService podService;

    @PostMapping("/super-admin/{stackId}/create-pod")
    public ResponseEntity<?> createPod(@PathVariable(name = "stackId") Long id,
                                       @RequestBody PodRequestDto requestDto){

           PodResponseDto response = podService.createPod(id, requestDto);
           return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping("/super-admin/update-pod/{podId}")
    public ResponseEntity<?> updatePod(@PathVariable(name = "podId") Long id, @RequestBody PodRequestDto requestDto ){podService.updatePod(id, requestDto);
        return new ResponseEntity<>(new APIResponse<>(true, "pod successfully updated ",null),HttpStatus.OK );
    }

}