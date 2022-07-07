package edu.miu.amp.controller;
import edu.miu.amp.dto.JobApplicationDto;
import edu.miu.amp.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job-applications")
public class JobApplicationController {
    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping
    public List<JobApplicationDto> findAll(){
        return jobApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public JobApplicationDto getById(@PathVariable Integer id){
        return jobApplicationService.findById(id);
    }

    @PostMapping
    public JobApplicationDto create(@RequestBody JobApplicationDto jobApplicationDto){
        return (jobApplicationService.save(jobApplicationDto));

    }

    @PutMapping("/{id}")
    public JobApplicationDto update(@RequestBody JobApplicationDto jobApplicationDto, @PathVariable Integer id){
        jobApplicationDto.setId(id);
        return jobApplicationService.save(jobApplicationDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        jobApplicationService.remove(id);
    }
}
