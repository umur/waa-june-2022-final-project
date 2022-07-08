package com.example.almuni.Controller;

import com.example.almuni.Dto.FacultyDto;
import com.example.almuni.service.Impl.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("faculty")
@CrossOrigin
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
  @PostMapping("/faculty")
   public ResponseEntity<FacultyDto> addFaculty(@RequestBody FacultyDto facultyDto){
       return  facultyService.addFaculty(facultyDto);
   }
   @GetMapping("/faculty")
    public ResponseEntity<List<FacultyDto>> getAllFaculty(){

      return facultyService.getAllFaculty();
    }

  @GetMapping("/{id}")
    public ResponseEntity<FacultyDto> getFacultyById(@PathVariable Long id){
       return facultyService.getFacultyById(id);
   }
   @DeleteMapping("/{id}")
   public String deleteById(@PathVariable Long id){
      return facultyService.deleteById(id);
   }
   @PutMapping("/{id}")
   public ResponseEntity<FacultyDto> update(@PathVariable Long id,@RequestBody FacultyDto facultyDto){
      return facultyService.updateFaculty(facultyDto,id);
   }

}
