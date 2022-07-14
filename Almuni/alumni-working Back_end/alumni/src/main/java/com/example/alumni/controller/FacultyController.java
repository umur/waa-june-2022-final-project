package com.example.alumni.controller;


import com.example.alumni.dto.FacultyDto;
import com.example.alumni.entity.Faculty;
import com.example.alumni.service.impl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/miu/faculty")
public class FacultyController {

    @Autowired
    private FacultyServiceImpl facultyService;

  @PostMapping
  @RolesAllowed("Admin")
   public ResponseEntity<FacultyDto> addFaculty(@RequestBody Faculty faculty){
       return  facultyService.addFaculty(faculty);
   }
   @GetMapping
   @RolesAllowed("Admin")
    public ResponseEntity<List<FacultyDto>> getAllFaculty(){

      return facultyService.getAllFaculty();
    }

  @GetMapping("/{id}")
  //@RolesAllowed("Admin")
    public ResponseEntity<FacultyDto> getFacultyById(@PathVariable Long id){
       return facultyService.getFacultyById(id);
   }
   @DeleteMapping("/{id}")
   @RolesAllowed("Admin")
   public String deleteById(@PathVariable Long id){
      return facultyService.deleteById(id);
   }

   @PutMapping("/{id}")
   @RolesAllowed("Faculty")
   public ResponseEntity<FacultyDto> update(@PathVariable Long id,@RequestBody Faculty faculty){
      return facultyService.updateFaculty(faculty,id);
   }

}
