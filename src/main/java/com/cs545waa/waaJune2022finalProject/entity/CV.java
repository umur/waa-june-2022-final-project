package com.cs545waa.waaJune2022finalProject.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private PersonalInformation personalInformation;

    @OneToOne
    private Address adddress;

    @OneToOne
    private ProfessionalExperiance professionalExperiance;

    @OneToOne
    private EducationHistory educationHistory;

}
