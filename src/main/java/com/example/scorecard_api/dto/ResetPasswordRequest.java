package com.example.scorecard_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequest {
    private String userOTP;
    private String newPassword;
    private String confirmPassword;
    private String email;
}
