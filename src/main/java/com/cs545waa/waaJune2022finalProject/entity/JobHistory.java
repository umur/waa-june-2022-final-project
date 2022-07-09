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
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reasonToLeave;
    private String comments;

    @ManyToMany
    private List<Tag> tags;
}
