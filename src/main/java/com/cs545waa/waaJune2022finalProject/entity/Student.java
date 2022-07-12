package com.cs545waa.waaJune2022finalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.ls.LSInput;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private float gpa;

    @ManyToOne
    private Department major;

    private LocalDateTime LastLoggedInAt;
    private boolean active;

    //Display 10 most recently applied job advertisements.
    //Students can apply to the jobs.
    @ManyToMany
    @JoinTable(name = "JobApplication")
    private List<JobAdvertisement> jobApplications;

    //Students can add job advertisements
    @OneToMany(mappedBy = "student")
    private List<JobAdvertisement> jobAdvertisements;


}
