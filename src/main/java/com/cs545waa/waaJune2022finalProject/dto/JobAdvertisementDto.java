package com.cs545waa.waaJune2022finalProject.dto;

import com.cs545waa.waaJune2022finalProject.entity.Address;
import com.cs545waa.waaJune2022finalProject.entity.JobAttachment;
import com.cs545waa.waaJune2022finalProject.entity.Student;
import com.cs545waa.waaJune2022finalProject.entity.Tag;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
public class JobAdvertisementDto {
    private Integer id;
    private String companyName;
    private String description;
    private String benefits;
    private List<Tag> tags;
    @JsonManagedReference(value = "attach")
    private List<JobAttachmentDTO> jobAttachments;
    @JsonBackReference
    private StudentDto student;
    @JsonManagedReference(value = "students")
    private List<StudentDto> students;
    @JsonManagedReference(value = "address")
    private AddressDto address;
}
