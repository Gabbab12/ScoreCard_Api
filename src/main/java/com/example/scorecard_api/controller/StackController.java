package com.example.scorecard_api.controller;


import com.example.scorecard_api.dto.requestdto.StackDto;
import com.example.scorecard_api.dto.responsedto.APIResponse;
import com.example.scorecard_api.model.Stack;
import com.example.scorecard_api.model.StackTemplate;
import com.example.scorecard_api.service.StackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class StackController {

    private final StackService stackService;

    @PostMapping("/super-admin/create-stack-template")
    public ResponseEntity<APIResponse<StackTemplate>> createStackTemplate(@RequestBody StackDto stackdto) {
        APIResponse<StackTemplate> stack = stackService.createStackTemplate(stackdto);
        return new ResponseEntity<>(stack, HttpStatus.CREATED);
    }

    @PostMapping("/super-admin/{squadId}/create-stack")
    public ResponseEntity<APIResponse<Stack>> createStack(@PathVariable Long squadId, @RequestBody StackDto stackDto ){
        return new ResponseEntity<>(stackService.createStack(squadId,stackDto),HttpStatus.CREATED);
    }
}
