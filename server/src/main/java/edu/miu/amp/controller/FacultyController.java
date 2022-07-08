package edu.miu.amp.controller;

import edu.miu.amp.dto.FacultyDto;
import edu.miu.amp.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public ResponseEntity<List<FacultyDto>> findAll(){
        return new ResponseEntity<>(facultyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDto> getById(@PathVariable Integer id){
        return new ResponseEntity<>(facultyService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FacultyDto> create(@RequestBody FacultyDto facultyDto){
        return new ResponseEntity<> (facultyService.save(facultyDto), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultyDto> update(@RequestBody FacultyDto facultyDto, @PathVariable Integer id){
        facultyDto.setId(id);
        return new ResponseEntity<>(facultyService.save(facultyDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        facultyService.remove(id);
    }
}
