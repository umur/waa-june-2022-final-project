package com.cs545waa.waaJune2022finalProject.controller;


import com.cs545waa.waaJune2022finalProject.dto.StudentDto;
import com.cs545waa.waaJune2022finalProject.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Data
@AllArgsConstructor

public class StudentController {

    StudentService studentService;

    @PutMapping("update")
    public void editProfile(@RequestBody StudentDto studentDto) {
        studentService.editProfile(studentDto);
    }

}
