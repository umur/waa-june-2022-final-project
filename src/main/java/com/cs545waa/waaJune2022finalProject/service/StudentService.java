package com.cs545waa.waaJune2022finalProject.service;


import com.cs545waa.waaJune2022finalProject.dto.CvDto;
import com.cs545waa.waaJune2022finalProject.dto.ProfessionalExperienceDto;
import com.cs545waa.waaJune2022finalProject.dto.StudentDto;

public interface StudentService {


    void editProfile(StudentDto studentDto);

        void registerStudent(StudentDto dto);

    void addExperience(ProfessionalExperienceDto professionalExperienceDto);
}
