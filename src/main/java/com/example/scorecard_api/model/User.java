package com.example.scorecard_api.model;


import com.example.scorecard_api.enums.Gender;
import com.example.scorecard_api.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorColumn(name = "user_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "users")
public class User extends BaseClass implements Serializable {
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;
    private Boolean isAccountActive;
    private String userOTP;


    public void deactivateUser(){
        this.setIsAccountActive(false);
    }
    public void activateUser(){
        this.setIsAccountActive(true);
    }
}
