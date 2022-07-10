package com.finalproject.controllers;

import com.finalproject.models.User;
import com.finalproject.payload.request.PostRequest;
import com.finalproject.payload.response.MessageResponse;
import com.finalproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<User> findAll() {
        return studentService.findAllStudent();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable long id) {
        return studentService.findById(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> post(@Valid @RequestBody PostRequest postRequest, @PathVariable long id) {
        studentService.post(postRequest, id);
        return ResponseEntity.ok(new MessageResponse("Commented posted successfully!"));
    }
}
