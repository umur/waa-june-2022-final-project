package com.cs545waa.waaJune2022finalProject.service.impl;

import com.cs545waa.waaJune2022finalProject.dto.StudentDto;
import com.cs545waa.waaJune2022finalProject.entity.Student;
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

    @Override
    public void editProfile(StudentDto studentDto) {
        //Student student = modelMapper.map(studentDto , Student.class);


//        studentRepo.update(student);
    }
}
