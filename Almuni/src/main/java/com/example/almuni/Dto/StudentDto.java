package com.example.almuni.dto;

import com.example.almuni.entity.Department;
import com.example.almuni.entity.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Float gpa;
    private Role role;
    private Department major;
    private Boolean active;
    private LocalDate lastLoggedInAt;

}
