package com.example.scorecard_api.model;

import com.example.scorecard_api.enums.Gender;
import com.example.scorecard_api.enums.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue(value = "super_admin")
@Entity
public class SuperAdmin extends User{

    @OneToMany
    @JoinColumn(name = "superadmin_squad", referencedColumnName = "id")
    private List<Squad> squad;
    @OneToMany
    @JoinColumn(name = "superadmin_stack", referencedColumnName = "id")
    private List<Stack> stack;
    @OneToMany
    @JoinColumn(name = "superadmin_pod", referencedColumnName = "id")
    private List<Pod> pod;


    public SuperAdmin(String firstName, String lastName, Gender gender, String email, Role role, String password, Boolean isAccountActive) {
//        super();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setEmail(email);
        this.setRole(role);
        this.setPassword(password);
        this.setIsAccountActive(isAccountActive);
    }
}
