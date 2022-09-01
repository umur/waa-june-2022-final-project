package edu.miu.amp.controller;

import edu.miu.amp.dto.FacultyDto;
import edu.miu.amp.dto.StudentDto;
import edu.miu.amp.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/v1/api/faculties")
@CrossOrigin
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/profile")
    @RolesAllowed("faculty")

    public ResponseEntity<FacultyDto> getMyProfile() {
        return ResponseEntity.ok(this.facultyService.getMyProfile());
    }

    @GetMapping
    @RolesAllowed("faculty")
    public ResponseEntity<List<FacultyDto>> findAll(){
        return new ResponseEntity<>(facultyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @RolesAllowed("faculty")
    public ResponseEntity<FacultyDto> getById(@PathVariable Integer id){
        return new ResponseEntity<>(facultyService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @RolesAllowed("faculty")
    public ResponseEntity<FacultyDto> create(@RequestBody FacultyDto facultyDto){
        return new ResponseEntity<> (facultyService.save(facultyDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @RolesAllowed("faculty")
    public ResponseEntity<FacultyDto> update(@RequestBody FacultyDto facultyDto, @PathVariable Integer id){
        facultyDto.setId(id);
        return new ResponseEntity<>(facultyService.save(facultyDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("admin")
    public void delete(@PathVariable Integer id){
        facultyService.remove(id);
    }
}
