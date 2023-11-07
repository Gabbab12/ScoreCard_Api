package com.example.scorecard_api.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginResponse {
    private Boolean status;
    private String message;
    private String token;
    private UserDto userDto;
}
