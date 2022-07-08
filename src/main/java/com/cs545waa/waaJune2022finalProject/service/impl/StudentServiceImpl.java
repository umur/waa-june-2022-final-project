package com.cs545waa.waaJune2022finalProject.service.impl;

import com.cs545waa.waaJune2022finalProject.dto.CvDto;
import com.cs545waa.waaJune2022finalProject.dto.ProfessionalExperienceDto;
import com.cs545waa.waaJune2022finalProject.dto.StudentDto;
import com.cs545waa.waaJune2022finalProject.entity.*;
import com.cs545waa.waaJune2022finalProject.repository.AddressRepo;
import com.cs545waa.waaJune2022finalProject.repository.CvRepo;
import com.cs545waa.waaJune2022finalProject.repository.StudentRepo;
import com.cs545waa.waaJune2022finalProject.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Data
@Transactional

public class StudentServiceImpl implements StudentService {

    StudentRepo studentRepo;
    ModelMapper modelMapper;
    CvRepo cvRepo;
    AddressRepo addressRepo;


    @Override
    public void editProfile(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        Address address = student.getAddress();
        studentRepo.save(student);
        addressRepo.save(address);
        
    }


    @Override
    public void addExperience(ProfessionalExperienceDto professionalExperienceDto) {
//        ProfessionalExperience professionalExperience =
//                modelMapper.map(professionalExperienceDto , ProfessionalExperience.class);
//        Integer i =1;
//        Cv cv = cvRepo.findAllById(i);
//        cv.getProfessionalExperience().add(professionalExperience);
//        cvRepo.save(cv);

    }
}
