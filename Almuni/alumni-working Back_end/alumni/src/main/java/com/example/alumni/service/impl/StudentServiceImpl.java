package com.example.alumni.service.impl;


import com.example.alumni.dto.StudentDto;
import com.example.alumni.entity.Department;
import com.example.alumni.entity.Student;
import com.example.alumni.repository.IStudentRepository;
import com.example.alumni.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto deleteStudentById(Long id) {

        if(studentRepository.findById(id).isPresent()){
            Student deletedStudent =  studentRepository.findById(id).get();
          studentRepository.delete(deletedStudent);
          return modelMapper.map(deletedStudent,StudentDto.class);
        }else {
            throw new IllegalStateException("There is no such student with this " + id);
        }
    }

    @Override
    public StudentDto updateStudent(Long id) {

        if(studentRepository.findById(id).isPresent()){
            Student updatedStudent =  studentRepository.findById(id).get();
            studentRepository.save(updatedStudent);
            return modelMapper.map(updatedStudent, StudentDto.class);
        }else {
            throw new IllegalStateException("There is no such student with this " + id);
        }
    }

    @Override
    public StudentDto addNewStudent(Student student) {

        return modelMapper.map(studentRepository.save(student), StudentDto.class);
    }

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

    @Override
    public Student findByEmail(String email) {
        var studentByEmail = studentRepository.findByEmail(email);
        return studentByEmail;
    }
}
