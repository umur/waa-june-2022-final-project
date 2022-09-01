package edu.miu.amp.controller;

import edu.miu.amp.dto.JobHistoryDto;
import edu.miu.amp.dto.StudentDto;
import edu.miu.amp.dto.response.ApiResponse;
import edu.miu.amp.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/api/students")
@AllArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/profile")
    @RolesAllowed("student")

    public ResponseEntity<StudentDto> getMyProfile() {
        return ResponseEntity.ok(this.studentService.getMyProfile());
    }

    @GetMapping
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(this.studentService.findAll());
    }

    @GetMapping("/{id}/job-history")
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<List<JobHistoryDto>> getStudentJobHistory(@PathVariable Integer id) {
        return ResponseEntity.ok(this.studentService.getStudentJobHistory(id));
    }

    @GetMapping("/{id}")
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.studentService.findById(id));
    }

    @PostMapping
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<StudentDto> createUser(@Valid @RequestBody StudentDto studentDto) {
        StudentDto createdUserDto = this.studentService.save(studentDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto studentDto, @PathVariable("id") Integer studentId) {
        StudentDto updatedStudent = this.studentService.update(studentDto, studentId);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{id}")
    @RolesAllowed("admin")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Integer id) {
        this.studentService.remove(id);
        return new ResponseEntity<>(new ApiResponse(true, "Student Removed Successfully"), HttpStatus.OK);
    }
}