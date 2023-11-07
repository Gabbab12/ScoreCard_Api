package com.example.scorecard_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pod extends BaseClass{

    private  String podName;
    private String PodHealth = "0";
    @JsonManagedReference
    @ManyToMany(mappedBy = "pods")
    private List<Admin> admin = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "pod")
    private  List<Decadev> decadev = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pod_id", referencedColumnName = "id")
    private Stack stack;


}
