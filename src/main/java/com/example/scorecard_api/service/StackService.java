package com.example.scorecard_api.service;

import com.example.scorecard_api.dto.requestdto.StackDto;
import com.example.scorecard_api.dto.responsedto.APIResponse;
import com.example.scorecard_api.model.Stack;
import com.example.scorecard_api.model.StackTemplate;

public interface StackService {

      APIResponse <StackTemplate> createStackTemplate(StackDto stackDto);
      APIResponse<Stack> createStack(long squadId, StackDto stackDto);
}
