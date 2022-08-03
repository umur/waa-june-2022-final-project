package com.cs545waa.waaJune2022finalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String companyName;
    LocalDate startDate;
    LocalDate finishDate;
    String description;

    @ManyToMany
    private List<Tag> tags;

    @ManyToOne
    Student student;

}
