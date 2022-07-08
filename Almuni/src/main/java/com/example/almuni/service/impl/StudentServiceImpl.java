package com.example.almuni.service.impl;

import com.example.almuni.dto.StudentDto;
import com.example.almuni.entity.Department;
import com.example.almuni.entity.Student;
import com.example.almuni.repository.StudentRepository;
import com.example.almuni.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDto> findStudentsByState(String state) {
        var studentByState =  studentRepository.findStudentsByState(state);

        return studentByState.stream()
                .map(student -> modelMapper.map(student,StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> findStudentsByCity(String city) {
        var studentByCity = studentRepository.findStudentsByCity(city);

        return studentByCity.stream()
                .map(student -> modelMapper.map(student,StudentDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<StudentDto> findStudentByMajor(Department major) {
        var studentByMajor = studentRepository.findStudentByMajor(major);

        return studentByMajor.stream()
                .map(student -> modelMapper.map(student,StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> findAllStudent() {
        var allStudent =  studentRepository.findAll();
        var studentDto = new ArrayList<StudentDto>();

       allStudent.forEach(student ->{
               studentDto.add(modelMapper.map(student,StudentDto.class));
        });
       return studentDto;
    }
    /**
     * this is test
     */
    public void test(){
        System.out.println("test");
    }
}
