package com.cs545waa.waaJune2022finalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
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
    private String passwpord;

    @ManyToOne
    private Department department;

    private LocalDateTime LastLoggedInAt;
    private boolean active;

    //Faculty can write comments on students.
    //  Only faculty can see the comments.
    @OneToMany
    private List<FacultyFeedback> facultyFeedbacks;
}
