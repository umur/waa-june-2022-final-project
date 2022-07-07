package edu.miu.amp.controller;

import edu.miu.amp.dto.DepartmentDto;
import edu.miu.amp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDto> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public DepartmentDto getById(@PathVariable Integer id){
        return departmentService.findById(id);
    }

    @PostMapping
    public DepartmentDto create(@RequestBody DepartmentDto departmentDto){
        return (departmentService.save(departmentDto));

    }

    @PutMapping("/{id}")
    public DepartmentDto update(@RequestBody DepartmentDto departmentDto, @PathVariable Integer id){
        departmentDto.setId(id);
        return departmentService.save(departmentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        departmentService.remove(id);
    }
}
