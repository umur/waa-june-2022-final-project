package com.example.almuni.service;

import com.example.almuni.dto.StudentDto;
import com.example.almuni.entity.Department;
import com.example.almuni.entity.Student;

import java.util.List;

public interface StudentService {

    List<StudentDto> findStudentsByState(String state);
    List<StudentDto> findStudentsByCity(String city);
    List<StudentDto> findStudentByMajor(Department major);
    List<StudentDto> findAllStudent();
}
