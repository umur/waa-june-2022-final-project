package com.example.alumni.dto;

import lombok.Data;

import javax.persistence.*;


@Data
public class AddressDto {


    private Long id;
    private String street;
    private String city;
    private String state;
    private int zipCode;

    @OneToOne
    private StudentDto student;
    @OneToOne
    private FacultyDto faculty;
}
