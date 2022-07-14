package com.example.almuni.controller;

import com.example.almuni.dto.StudentDto;
import com.example.almuni.entity.Department;
import com.example.almuni.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> fetAllStudents(){

        var allStudents = studentService.findAllStudent();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/department/{major}")
    public ResponseEntity<List<StudentDto>> findAllStudentByMajor(@PathVariable Department major){

        var studentByMajor = studentService.findStudentByMajor(major);
        return ResponseEntity.ok(studentByMajor);
    }

    @GetMapping("/city/{name}")
    public ResponseEntity<List<StudentDto>> findStudentByCity(@PathVariable String name){

        var studentByCity = studentService.findStudentsByCity(name);
        return ResponseEntity.ok(studentByCity);
    }

    @GetMapping("/state/{name}")
    public ResponseEntity<List<StudentDto>> findStudentsByState(@PathVariable String name){

        var studentByState = studentService.findStudentsByState(name);
        return ResponseEntity.ok(studentByState);
    }
}
