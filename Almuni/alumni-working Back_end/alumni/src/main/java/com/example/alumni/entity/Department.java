package com.example.alumni.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "major")
    private List<Course> courses;
    @OneToMany(mappedBy = "major")
    private List<Faculty> faculties;
    @OneToMany(mappedBy = "major")
    private List<Student> students;
}
