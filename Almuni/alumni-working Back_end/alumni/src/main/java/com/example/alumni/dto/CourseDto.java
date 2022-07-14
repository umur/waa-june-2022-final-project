package com.example.alumni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {


    private Long id;

    private String name;
    private String courseCode;
    @ManyToOne
    private DepartmentDto major;

    @ManyToMany
    private List<StudentDto> students;
}
