package edu.miu.amp.controller;

import edu.miu.amp.dto.JobAdvertisementDto;
import edu.miu.amp.service.JobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/job-advertisements")
public class JobAdvertisementController {
    @Autowired
    private JobAdvertisementService jobAdvertisementService;

    @GetMapping
    public List<JobAdvertisementDto> findAll(){
        return jobAdvertisementService.findAll();
    }

    @GetMapping("/{id}")
    public JobAdvertisementDto getById(@PathVariable Integer id){
        return jobAdvertisementService.findById(id);
    }

    @PostMapping
    public JobAdvertisementDto create(@RequestBody JobAdvertisementDto jobAdvertisementDto){
        return (jobAdvertisementService.save(jobAdvertisementDto));

    }

    @PutMapping("/{id}")
    public JobAdvertisementDto update(@RequestBody JobAdvertisementDto jobAdvertisementDto, @PathVariable Integer id){
        jobAdvertisementDto.setId(id);
        return jobAdvertisementService.save(jobAdvertisementDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        jobAdvertisementService.remove(id);
    }
}
