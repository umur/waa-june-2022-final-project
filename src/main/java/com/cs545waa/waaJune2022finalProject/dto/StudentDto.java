package com.cs545waa.waaJune2022finalProject.dto;

import com.cs545waa.waaJune2022finalProject.entity.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;
    private String username;

     @JsonManagedReference(value = "stu")
    private AddressDto address;

    private Department major;

    private List<ProfessionalExperience> professionalExperiances;

    @ManyToMany
    private List<JobAdvertisementDto> jobApplicationsDto;

    @OneToMany
    private List<JobAdvertisementDto> jobAdvertisementsDto;

    @OneToMany
    private List<ProfessionalExperienceDto> professionalExperiencesDto;

//    @OneToOne
//    private Cv cv;
}


