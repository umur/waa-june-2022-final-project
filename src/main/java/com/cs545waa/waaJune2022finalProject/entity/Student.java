package com.cs545waa.waaJune2022finalProject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
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

    private String email;
    private String username;
    private String password;
    private float gpa;


    @OneToOne(mappedBy = "student",fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST,
            org.hibernate.annotations.CascadeType.SAVE_UPDATE,
    org.hibernate.annotations.CascadeType.DELETE})
    private Address address;

    @ManyToOne
    private Department major;

    private LocalDateTime LastLoggedInAt;
    private boolean active;

    //Students can add job advertisements
    @OneToMany(mappedBy = "student")
    private List<JobAdvertisement> jobAdvertisements;

    //Display 10 most recently applied job advertisements.
    //Students can apply to the jobs.
    @ManyToMany
    @JoinTable(name = "JobApplication")
    private List<JobAdvertisement> jobApplications;



    @OneToMany(mappedBy="student")
    private List<ProfessionalExperience> professionalExperiences;




}
