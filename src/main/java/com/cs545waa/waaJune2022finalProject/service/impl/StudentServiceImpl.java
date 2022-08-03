package com.cs545waa.waaJune2022finalProject.service.impl;

import com.cs545waa.waaJune2022finalProject.dto.CvDto;
import com.cs545waa.waaJune2022finalProject.dto.ProfessionalExperienceDto;
import com.cs545waa.waaJune2022finalProject.dto.StudentDto;
import com.cs545waa.waaJune2022finalProject.entity.*;
import com.cs545waa.waaJune2022finalProject.repository.AddressRepo;

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

    AddressRepo addressRepo;


    @Override
    public void editProfile(StudentDto studentDto, int id) {
        //Student student = modelMapper.map(studentDto, Student.class);
        //Address address = student.getAddress();
        //studentRepo.save(student);
        studentDto.setId(id);
        studentRepo.save(modelMapper.map(studentDto, Student.class));
        //addressRepo.save(modelMapper.map(studentDto.getAddress(), Address.class));
        
    }

    @Override
    public void registerStudent(StudentDto dto) {
        studentRepo.save(modelMapper.map(dto,Student.class));
    }


    @Override
    public void addExperience(ProfessionalExperienceDto professionalExperienceDto, String username) {
        ProfessionalExperience professionalExperience =
                modelMapper.map(professionalExperienceDto , ProfessionalExperience.class);
        professionalExperience.setStudent(studentRepo.getStudentByUsername(username));
        studentRepo.getStudentByUsername(username).getProfessionalExperiences().add(professionalExperience);

    }

    @Override
    public CvDto getCV(Integer id) {
        return modelMapper.map(studentRepo.findById(id),CvDto.class);
    }

    @Override
    public void getProfile(int id) {
        studentRepo.findById(id);
    }


    @Override
    public StudentDto getStudentByUsername(String username) {
//        studentRepo.ge

        return modelMapper.map(studentRepo.getStudentByUsername(username),StudentDto.class);
    }
}
