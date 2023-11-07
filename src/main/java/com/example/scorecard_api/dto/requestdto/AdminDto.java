package com.example.scorecard_api.dto.requestdto;


import com.example.scorecard_api.enums.AssignRole;
import com.example.scorecard_api.enums.Gender;
import com.example.scorecard_api.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private AssignRole assignRole;
    private Long squadId;
    private Long stackId;
    private Long podId;
    private Role role;
}