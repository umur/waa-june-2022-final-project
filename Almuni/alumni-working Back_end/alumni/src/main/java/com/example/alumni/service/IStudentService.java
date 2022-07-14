package com.example.alumni.service;


import com.example.alumni.dto.StudentDto;
import com.example.alumni.entity.Department;
import com.example.alumni.entity.Student;

import java.util.List;

public interface IStudentService {

    StudentDto deleteStudentById(Long id);
    StudentDto updateStudent(Long id);
    StudentDto addNewStudent(Student student);
    List<StudentDto> findStudentsByState(String state);
    List<StudentDto> findStudentsByCity(String city);
    List<StudentDto> findStudentByMajor(Department major);
    List<StudentDto> findAllStudent();
    Student findByEmail(String email);
}
