package com.example.scorecard_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "squad")
@AllArgsConstructor
@NoArgsConstructor
public class Squad extends BaseClass {

    private String squadName;
    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "squad_id", referencedColumnName = "id")
    private List<Stack> stacks;

    @JsonManagedReference
    @ManyToMany(mappedBy = "squads")
    private List<Admin> admin;

    @JsonBackReference
    @OneToMany(mappedBy = "squad")
    private List<Decadev> decadev;
}
