package com.example.almuni.dto;

import com.example.almuni.entity.Role;
import lombok.Data;

@Data
public class FacultyDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Float gpa;
    private Role role;
}
