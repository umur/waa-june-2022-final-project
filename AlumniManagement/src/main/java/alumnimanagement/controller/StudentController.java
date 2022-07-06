package alumnimanagement.controller;

import alumnimanagement.dto.StudentDTO;
import alumnimanagement.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")

public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.create(studentDTO);

    }

    @GetMapping
    public List<StudentDTO> findAllStudent() {
        return studentService.findAll();
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable long id, @RequestBody StudentDTO studentDTO) throws Exception {
        studentService.update(id, studentDTO);
    }

    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable long id) {
        studentService.remove(id);
    }
}
