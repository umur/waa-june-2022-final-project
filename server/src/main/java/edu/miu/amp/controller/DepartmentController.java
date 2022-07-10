package edu.miu.amp.controller;

import edu.miu.amp.dto.DepartmentDto;
import edu.miu.amp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("v1/api/departments")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<List<DepartmentDto>> findAll() {
        return new ResponseEntity<>(departmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<DepartmentDto> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(departmentService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<DepartmentDto> create(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.save(departmentDto), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<DepartmentDto> update(@RequestBody DepartmentDto departmentDto, @PathVariable Integer id) {
        departmentDto.setId(id);
        return new ResponseEntity<>(departmentService.save(departmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("admin")
    public void delete(@PathVariable Integer id) {
        departmentService.remove(id);
    }
}
