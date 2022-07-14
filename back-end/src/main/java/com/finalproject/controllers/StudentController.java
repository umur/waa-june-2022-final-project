package com.finalproject.controllers;

import com.finalproject.models.Student;
import com.finalproject.models.User;
import com.finalproject.payload.request.PostRequest;
import com.finalproject.payload.response.MessageResponse;
import com.finalproject.security.services.UserDetailsImpl;
import com.finalproject.service.StudentService;
import com.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    UserService userService; /// added


    // list all the  students
    @GetMapping
    public List<User> findAll() {
        List<User> students = new ArrayList<>();
        studentService.findAllStudent().forEach(s -> {
            if (s.getStudent() !=null) {
                students.add(s);
            }
        });
        return students;
    }


    @GetMapping("/countByCity")
    public Integer countByCity(@RequestParam String city) throws Exception {
        return studentService.countByCity(city);
    }
    @GetMapping("/countByState")
    public Integer countByState(@RequestParam String state) throws Exception {
        return studentService.countByState(state);
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

 // newly added
    @PutMapping("/profile")
    public void updateProfile(@RequestBody Student student ) {
        Object pr = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (pr instanceof UserDetailsImpl) {
            String username = ((UserDetailsImpl) pr).getUsername();
            var n =userService.findBYUserName(username).getStudent();

            studentService.updateProfile(student , n.getId());
        } else {
            throw new SecurityException("could not reseted");
        }
    }



}
