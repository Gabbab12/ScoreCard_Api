package com.example.scorecard_api.serviceImpl;


import com.example.scorecard_api.dto.requestdto.StackDto;
import com.example.scorecard_api.dto.responsedto.APIResponse;
import com.example.scorecard_api.exception.SquadNotFoundException;
import com.example.scorecard_api.exception.StackAlreadyExistException;
import com.example.scorecard_api.model.Squad;
import com.example.scorecard_api.model.Stack;
import com.example.scorecard_api.model.StackTemplate;
import com.example.scorecard_api.repository.SquadRepository;
import com.example.scorecard_api.repository.StackRepository;
import com.example.scorecard_api.repository.StackTemplateRepository;
import com.example.scorecard_api.service.StackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StackServiceImpl implements StackService {

    private final StackTemplateRepository stackTemplateRepository;
    private final SquadRepository squadRepository;
    private  final StackRepository stackRepository;

    @Override
    public APIResponse<StackTemplate> createStackTemplate(StackDto stackDto) {

       StackTemplate  stack = stackTemplateRepository.findByStackNameIgnoreCase(stackDto.getStackName());
        if (stack == null) {
            StackTemplate newStack = new StackTemplate();
            newStack.setStackName(stackDto.getStackName().toUpperCase());
            stackTemplateRepository.save(newStack);
            return new APIResponse<>(true,"Stack Successfully Created",newStack);
        }else{
            return new APIResponse<>(true,"Stack already exist");

        }

    }

    @Override
    public APIResponse<Stack> createStack(long squadId, StackDto stackDto) {
        Squad squad = squadRepository.findById(squadId).orElseThrow(()->new SquadNotFoundException("Squad not found"));
        if(!stackTemplateRepository.existsByStackName(stackDto.getStackName().toUpperCase())){
            StackTemplate newStack = new StackTemplate();
            newStack.setStackName(stackDto.getStackName().toUpperCase());
            stackTemplateRepository.save(newStack);
        }
        if(stackRepository.existsBySquadAndStackName(squad,stackDto.getStackName().toUpperCase())){
            throw new StackAlreadyExistException("Stack already created for this squad");
        }else {
            Stack stack = new Stack();
            stack.setStackName(stackDto.getStackName().toUpperCase());
            stack.setSquad(squad);
            return new APIResponse<>(true,"Stack created successfully",stackRepository.save(stack));
        }
    }


}
