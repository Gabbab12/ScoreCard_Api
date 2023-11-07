package com.example.scorecard_api.service;


import com.example.scorecard_api.dto.ChangePasswordRequest;
import com.example.scorecard_api.dto.ForgetPasswordRequest;
import com.example.scorecard_api.dto.ResetPasswordRequest;
import com.example.scorecard_api.dto.requestdto.AdminDto;
import com.example.scorecard_api.dto.requestdto.StackDto;
import com.example.scorecard_api.dto.responsedto.APIResponse;
import com.example.scorecard_api.dto.responsedto.PodResponseDto;
import com.example.scorecard_api.dto.responsedto.SquadDto;
import com.example.scorecard_api.dto.responsedto.StackResponseDto;
import com.example.scorecard_api.model.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SuperAdminService {

    List<Pod> listOfPods();

    String removeAdminById(Long id);

    User CreateAdmin(AdminDto adminDto);

    String createSquad(SquadDto squadDto);

    APIResponse getAdmin(Long id);

    Page<Squad> getAllSquads(int offset, int pageSize);

    List<StackResponseDto> getDetailsOfAllStacks(Long squadId);

    Stack getStackUsingId(Long id);

    APIResponse<String> updateStack(StackDto stackDto, Long id);
    APIResponse<Admin> updateAdmin(AdminDto adminDto, Long adminId);

    APIResponse<User>activateAdmin(Long adminId);
    APIResponse<User> deactivateAdmin(Long adminId);

    Pod getPod(Long id);

    APIResponse<?> forgotPassword(ForgetPasswordRequest request);

    APIResponse<?> resetPassword(ResetPasswordRequest request);


    APIResponse<?> changePassword(ChangePasswordRequest request, String email);

    List<PodResponseDto> getAllPodsInAStack(Long stackId);
}

