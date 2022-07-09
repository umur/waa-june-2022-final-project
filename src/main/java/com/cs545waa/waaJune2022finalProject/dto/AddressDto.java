package com.cs545waa.waaJune2022finalProject.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class AddressDto {
    private int id;
    private String street;
    private String city;
    private String state;
    private int zip;
 @JsonBackReference(value = "stu")
    private StudentDto student;
}

