package com.cs545waa.waaJune2022finalProject.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ProfessionalExperienceDto {
    private Integer id;
    private String companyName;
    private LocalDate startDate;
    private LocalDate finishDate;
    private String description;
    @JsonBackReference(value = "experiences")
    private StudentDto student;
}
