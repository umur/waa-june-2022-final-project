package com.finalproject.controllers;

import com.finalproject.models.Student;
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


    // list all the  students
    @GetMapping
    public List<User> findAll() {
        return studentService.findAllStudent();
    }

    // get student by id

    @GetMapping("/{id}")
    public User findById(@PathVariable long id) throws Exception {
        return studentService.findById(id);
    }



    // get student by Student-id

    @GetMapping("/ByStudent_Id/{id}")
    public Student  findById(@PathVariable  Integer id) throws Exception {
        return studentService.getByStudentId(id);
    }

// search students by name
    @GetMapping("/name")
    public List<Student> findById(@RequestParam String name) {
        return studentService.getByName(name);
    }

    // search students by city
    @GetMapping("/city")
    public List< Student> findByCity(@RequestParam String city) {
        return studentService.getByCity(city);
    }

    // search student by state

    @GetMapping("/state")
    public List< Student> findByByState(@RequestParam String state) {
        return studentService.getByState(state);
    }


    // search student by major
    @GetMapping("/major")
    public List< Student> findByByMajor(@RequestParam String major) {
        return studentService.getByMajor(major);
    }

    //  faculty  add a comment
    @PostMapping("/{id}")
    public ResponseEntity<?> post(@Valid @RequestBody PostRequest postRequest, @PathVariable long id) {
        studentService.post(postRequest, id);
        return ResponseEntity.ok(new MessageResponse("Commented posted successfully!"));
    }

    //admin can soft_delete student
    @PostMapping("/delete/{id}")
    public void deleted(@PathVariable Long id){
        studentService.deleteStudent(id);
    }



}
