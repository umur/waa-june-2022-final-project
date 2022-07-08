package com.cs545waa.waaJune2022finalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToMany
    private List<ProfessionalExperience> professionalExperience;

    @OneToMany
    private List<EducationHistory> educationHistory;

    @OneToOne
    Student student;

}
