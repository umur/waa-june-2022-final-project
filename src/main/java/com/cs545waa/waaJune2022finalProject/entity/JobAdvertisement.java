package com.cs545waa.waaJune2022finalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String companyName;
    private String description;
    private String benefits;

    @ManyToMany
    private List<Tag> tags;

    @OneToMany
    private List<JobAttachment> files;

    @ManyToOne
    private Student student;

    @ManyToMany(mappedBy = "jobApplications")
    private List<Student> applicants;

    @OneToOne(mappedBy = "jobAd",fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST,
            org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.DELETE})
    private Address address;
}
