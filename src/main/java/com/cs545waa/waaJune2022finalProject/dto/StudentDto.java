package com.cs545waa.waaJune2022finalProject.dto;

import com.cs545waa.waaJune2022finalProject.entity.Address;
import com.cs545waa.waaJune2022finalProject.entity.Department;
import com.cs545waa.waaJune2022finalProject.entity.ProfessionalExperiance;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;

    @NotNull
    private Address adddress;


    private Department major;

    private List<ProfessionalExperiance> professionalExperiances;
}


