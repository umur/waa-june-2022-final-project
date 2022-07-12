package com.cs545waa.waaJune2022finalProject.dto;

import com.cs545waa.waaJune2022finalProject.entity.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

// this id just for a view/ not edit cv
public class CvDto {

    private String firstName;

    private String lastName;

    private String email;

    private float gpa;
    private List<ProfessionalExperience> professionalExperience;
    private List<EducationHistory> educationHistory;
    private Address address;

    private Department major;
}
