package com.example.almuni.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyDto {


    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Float gpa;
    //private Role role;

    @OneToOne(mappedBy = "faculty")
    private AddressDto address;

    @ManyToOne
    private DepartmentDto major;
    private Boolean active;
    private LocalDate lastLoggedInAt;

}
