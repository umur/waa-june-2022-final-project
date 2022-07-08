package edu.miu.amp.controller;

import edu.miu.amp.dto.StudentDto;
import edu.miu.amp.dto.response.ApiResponse;
import edu.miu.amp.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/api/students")
@AllArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(this.studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createUser(@Valid @RequestBody StudentDto studentDto) {
        StudentDto createdUserDto = this.studentService.save(studentDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto studentDto, @PathVariable("id") Integer studentId) {
        StudentDto updatedStudent = this.studentService.update(studentDto, studentId);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Integer id) {
        this.studentService.remove(id);
        return new ResponseEntity<>(new ApiResponse(true, "Student Removed Successfully"), HttpStatus.OK);
    }
}