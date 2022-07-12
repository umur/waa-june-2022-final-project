package com.cs545waa.waaJune2022finalProject.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
public class JobAdvertisementDto {
    private Integer id;
    private String companyName;
    private String description;
    private String benefits;
    private List<TagDTO> tags;

    @JsonManagedReference(value = "attach")
    private List<JobAttachmentDTO> jobAttachments;
    @JsonBackReference(value = "advertisements")
    private StudentDto student;
    @JsonManagedReference(value = "applicants")
    private List<JobApplicationDTO> jobApplications;

    @JsonManagedReference(value = "dutyStation")
    private AddressDto address;
}
