package com.cs545waa.waaJune2022finalProject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProfileDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private AddressDto address;
    private DepartmentDTO major;
    private List<ProfessionalExperienceDto> professionalExperiences;
}
