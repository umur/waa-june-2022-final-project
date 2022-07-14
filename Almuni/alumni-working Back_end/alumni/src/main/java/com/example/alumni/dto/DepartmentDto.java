package com.example.alumni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {


    private Long id;
    private String name;

    @OneToMany(mappedBy = "major")
    private List<CourseDto> courses;
    @OneToMany(mappedBy = "major")
    private List<FacultyDto> faculties;
    @OneToMany(mappedBy = "major")
    private List<StudentDto> students;
}
