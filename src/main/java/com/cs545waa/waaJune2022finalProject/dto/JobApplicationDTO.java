package com.cs545waa.waaJune2022finalProject.dto;

import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import com.cs545waa.waaJune2022finalProject.entity.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class JobApplicationDTO {
    private Integer id;
    @JsonBackReference(value = "applications")
    private StudentDto student;
    @JsonBackReference(value="applicants")
    private JobAdvertisementDto jobAdvertisement;
}
