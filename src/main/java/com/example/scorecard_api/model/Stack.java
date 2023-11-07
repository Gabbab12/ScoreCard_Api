package com.example.scorecard_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class  Stack extends  BaseClass{
    private String stackName;


   @JsonManagedReference
    @OneToMany(mappedBy = "stack")
    private List<Pod> pods = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "stack")
    private List<Decadev> decadev = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "stacks")
    private List<Admin> admin = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Squad squad ;



}
