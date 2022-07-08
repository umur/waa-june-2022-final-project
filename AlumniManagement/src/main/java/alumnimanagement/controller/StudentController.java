package alumnimanagement.controller;

import alumnimanagement.dto.StudentDTO;
import alumnimanagement.dto.StudentListDto;
import alumnimanagement.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
@CrossOrigin

public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        System.out.println("Student is created");
        studentService.create(studentDTO);
        return new ResponseEntity(studentDTO, HttpStatus.OK);

    }

    @GetMapping
    public List<StudentDTO> findAllStudent() {
        return studentService.findAll();
    }

    @GetMapping("/getAll")
    public List<StudentListDto> findAllStudent(@RequestParam int page, @RequestParam int size, @RequestParam String searchValue)
    {
        var result = studentService.findAllByParam(page,size,searchValue);
        return result;
    }

    @GetMapping("/count")
    public Long totalStudents() {
        return studentService.totalStudents();
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable long id, @RequestBody StudentDTO studentDTO) throws Exception {
        studentService.update(id, studentDTO);
    }

    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable long id) {
        studentService.remove(id);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable long id){
        return studentService.findStudentById(id);
    }
}
