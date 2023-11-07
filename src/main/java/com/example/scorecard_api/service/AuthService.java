package com.example.scorecard_api.service;


import com.example.scorecard_api.dto.requestdto.LoginDto;
import com.example.scorecard_api.dto.responsedto.LoginResponse;

public interface AuthService{
    LoginResponse login(LoginDto loginDto) throws Exception;
}
