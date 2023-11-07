package com.example.scorecard_api.response;

import com.example.scorecard_api.model.Admin;
import com.example.scorecard_api.model.Pod;
import com.example.scorecard_api.model.Squad;
import com.example.scorecard_api.model.Stack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {
    private String firstName;
    private String lastName;
    private String email;
    private List<Squad> squads;
    private List<Stack> stacks;
    private List<Pod> pods;


    public AdminResponse(Admin admin) {
        this.firstName = admin.getFirstName();
        this.lastName = admin.getLastName();
        this.email = admin.getEmail();
        this.squads = admin.getSquads();
        this.stacks = admin.getStacks();
        this.pods = admin.getPods();

    }
}
