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

    @GetMapping("/{state}/{city}/{major}/{studentName}/{studentId}/getAll")
    public List<StudentListDto> findAllStudent(@PathVariable String state, @PathVariable String city,@PathVariable String major,@PathVariable String studentName,@PathVariable String studentId,@RequestParam int page, @RequestParam int size, @RequestParam String searchValue)
    {
        if(state.equals("undefined"))
            state = "''";
        if(city.equals("undefined"))
            city = "''";
        if(major.equals("undefined"))
            major = "''";
        if(studentName.equals("undefined"))
            studentName = "''";
        long stuId=0L;
        if(!studentId.equals("undefined")&& !studentId.equals("''") && !studentId.equals(""))
            stuId = Long.parseLong(studentId);
        var result = studentService.findAllByParam(page,size,state, city, major,studentName,stuId);
        return result;
    }

    @GetMapping("/{state}/{city}/{major}/{studentName}/{studentId}/count")
    public Long count(@PathVariable String state, @PathVariable String city,@PathVariable String major,@PathVariable String studentName,@PathVariable String studentId)
    {
        if(state.equals("undefined"))
            state = "''";
        if(city.equals("undefined"))
            city = "''";
        if(major.equals("undefined"))
            major = "''";
        if(studentName.equals("undefined"))
            studentName = "''";
        long stuId=0L;
        if(!studentId.equals("undefined")&& !studentId.equals("''") && !studentId.equals(""))
            stuId = Long.parseLong(studentId);
        return studentService.totalStudents(state, city, major,studentName,stuId);
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
