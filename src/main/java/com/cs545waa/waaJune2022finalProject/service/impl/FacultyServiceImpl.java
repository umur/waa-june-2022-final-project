package com.cs545waa.waaJune2022finalProject.service.impl;

import com.cs545waa.waaJune2022finalProject.dto.FacultyDto;
import com.cs545waa.waaJune2022finalProject.dto.StudentDto;
import com.cs545waa.waaJune2022finalProject.entity.Address;
import com.cs545waa.waaJune2022finalProject.entity.Faculty;
import com.cs545waa.waaJune2022finalProject.entity.Student;
import com.cs545waa.waaJune2022finalProject.repository.AddressRepo;
import com.cs545waa.waaJune2022finalProject.repository.FacultyRepo;
import com.cs545waa.waaJune2022finalProject.service.FacultyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Data
@Transactional
public class FacultyServiceImpl implements FacultyService {

    FacultyRepo facultyRepo;
    ModelMapper modelMapper;
    AddressRepo addressRepo;



    @Override
    public void registerFaculty(FacultyDto facultyDto) {
        facultyRepo.save(modelMapper.map(facultyDto, Faculty.class));
    }

    @Override
    public void editProfile(FacultyDto facultyDto, int id) {
        //Student student = modelMapper.map(studentDto, Student.class);
        //Address address = student.getAddress();
        //studentRepo.save(student);
        facultyDto.setId(id);
        facultyRepo.save(modelMapper.map(facultyDto, Faculty.class));
        addressRepo.save(modelMapper.map(facultyDto.getAddress(), Address.class));

    }

    @Override
    public FacultyDto getFacultyByUsername(String username) {
        return modelMapper.map(facultyRepo.getStudentByUsername(username),FacultyDto.class);
    }
}
