package com.example.scorecard_api.serviceImpl;

import com.example.scorecard_api.exception.SquadNotFoundException;
import com.example.scorecard_api.model.Squad;
import com.example.scorecard_api.repository.SquadRepository;
import com.example.scorecard_api.service.SquadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SquadImpl implements SquadService {
   private  final SquadRepository squadRepository;


    @Override
    public Squad getSquad(Long id) {
        Squad squad = squadRepository.findById(id).orElseThrow(()-> new SquadNotFoundException("Squad not found"));

        return squad;
    }
}
