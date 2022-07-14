package com.cs545waa.waaJune2022finalProject.service;


import com.cs545waa.waaJune2022finalProject.dto.CvDto;
import com.cs545waa.waaJune2022finalProject.dto.ProfessionalExperienceDto;
import com.cs545waa.waaJune2022finalProject.dto.StudentDto;

public interface StudentService {


    void editProfile(StudentDto studentDto, int id);

        void registerStudent(StudentDto dto);

        StudentDto getStudentByUsername(String username);
    void addExperience(ProfessionalExperienceDto professionalExperienceDto,String username);
    public void removeExperience(Integer experienceId,String Username);
    public CvDto getCV(Integer id);


    void getProfile(int id);
}
