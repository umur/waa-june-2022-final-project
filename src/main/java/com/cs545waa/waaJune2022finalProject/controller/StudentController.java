package com.cs545waa.waaJune2022finalProject.controller;

import com.cs545waa.waaJune2022finalProject.dto.AdvertisementDto;
import com.cs545waa.waaJune2022finalProject.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@Data
@AllArgsConstructor

public class StudentController {

    StudentService studentService;



}
