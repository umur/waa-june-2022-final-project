package edu.miu.amp.controller;
import edu.miu.amp.dto.JobAdvertisementDto;
import edu.miu.amp.dto.JobApplicationDto;
import edu.miu.amp.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("v1/api/job-applications")
@CrossOrigin
public class JobApplicationController {
    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping
    @RolesAllowed({"student","faculty"})
    public ResponseEntity<List<JobApplicationDto>> findAll(){
        return new ResponseEntity<>(jobApplicationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @RolesAllowed({"student","faculty"})
    public ResponseEntity<JobApplicationDto> getById(@PathVariable Integer id){
        return new ResponseEntity<>(jobApplicationService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/last10-job-application")
    public ResponseEntity<List<JobApplicationDto>> findLast10JobApplied(){
        return new ResponseEntity<>(jobApplicationService.Top10JobApplicant(), HttpStatus.OK);
    }

    @PostMapping
    @RolesAllowed("student")
    public ResponseEntity<JobApplicationDto> create(@RequestBody JobApplicationDto jobApplicationDto){
        return new ResponseEntity<> (jobApplicationService.save(jobApplicationDto), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    @RolesAllowed("student")
    public ResponseEntity<JobApplicationDto> update(@RequestBody JobApplicationDto jobApplicationDto, @PathVariable Integer id){
        jobApplicationDto.setId(id);
        return new ResponseEntity<>(jobApplicationService.save(jobApplicationDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("student")
    public void delete(@PathVariable Integer id){
        jobApplicationService.remove(id);
    }
}
