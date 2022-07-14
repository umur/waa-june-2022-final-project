package com.example.alumni.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Float gpa;
    private ERole role;

    @ManyToOne
    private Department major;
    private Boolean active;
    private LocalDate lastLoggedInAt;

    @OneToOne(mappedBy = "student")
    private Address address;
    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    @OneToMany
    @JoinColumn(name="student_id")
    private List<Comment> comments;
}
