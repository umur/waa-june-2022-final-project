package com.cs545waa.waaJune2022finalProject.dto;

import com.cs545waa.waaJune2022finalProject.entity.Faculty;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class AddressDto {
    private int id;
    private String street;
    private String city;
    private String state;
    private int zip;
 @JsonBackReference(value = "mailingAddress")
    private StudentDto student;
    @JsonBackReference(value = "faculty")
    private FacultyDto faculty;
   @JsonBackReference(value = "dutyStation")
   private JobAdvertisementDto jobAdvertisement;
}

