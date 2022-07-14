package com.example.alumni.controller;


import com.example.alumni.dto.StudentDto;
import com.example.alumni.entity.Department;
import com.example.alumni.entity.Student;
import com.example.alumni.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/miu/students")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @DeleteMapping("/{id}")
   @RolesAllowed("Admin")
    public ResponseEntity<StudentDto> deleteStudentById(@PathVariable Long id){

        var studentDeleted = iStudentService.deleteStudentById(id);
        return ResponseEntity.ok(studentDeleted);
    }
    @PutMapping("/{id}")
    @RolesAllowed({"Faculty","Student"})
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id){
        var updatedStudent = iStudentService.updateStudent(id);
        return ResponseEntity.ok(updatedStudent);
    }
    @PostMapping
    @RolesAllowed("Admin")
    public ResponseEntity<StudentDto> addNewStudent(Student student){
        var newStudent = iStudentService.addNewStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping("/state/{state}")
   public ResponseEntity<List<StudentDto>> findStudentsByState(@PathVariable  String state){

       var studentByState = iStudentService.findStudentsByState(state);
       return ResponseEntity.ok(studentByState);
   }

   @GetMapping("/city/{city}")
    public ResponseEntity<List<StudentDto>> findStudentsByCity(@PathVariable  String city){

        var studentByCity = iStudentService.findStudentsByCity(city);
        return ResponseEntity.ok(studentByCity);
    }

    @GetMapping("/department/{major}")
    public ResponseEntity<List<StudentDto>> findStudentByMajor(Department major){

        var studentByMajor = iStudentService.findStudentByMajor(major);
        return ResponseEntity.ok(studentByMajor);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAllStudent(){

        var allStudents = iStudentService.findAllStudent();
        return ResponseEntity.ok(allStudents);
    }

}
