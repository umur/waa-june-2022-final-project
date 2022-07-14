package com.example.alumni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Float gpa;
    //private Role role;

    @ManyToOne
    private DepartmentDto major;
    private Boolean active;
    private LocalDate lastLoggedInAt;

    @OneToOne(mappedBy = "student")
    private AddressDto address;
    @ManyToMany(mappedBy = "students")
    private List<CourseDto> courses;

    @OneToMany
    @JoinColumn(name="student_id")
    private List<CommentDto> comments;
}
