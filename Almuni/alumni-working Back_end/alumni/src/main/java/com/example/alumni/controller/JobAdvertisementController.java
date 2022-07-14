package com.example.alumni.controller;


import com.example.alumni.dto.JobAdvertisementDto;
import com.example.alumni.entity.JobAdvertisement;
import com.example.alumni.service.IJobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miu/jobs")
public class JobAdvertisementController {

    @Autowired
    private IJobAdvertisementService jobAdvertisementService;

    @GetMapping
    public ResponseEntity<List<JobAdvertisementDto>> getAllJobsAds(){
        var allJobs =  jobAdvertisementService.findAllJobAds();
        return ResponseEntity.ok(allJobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobAdvertisementDto> getJobAdvertisementBtId(@PathVariable long id){
        var jobAddById = jobAdvertisementService.findJobAdvertisementById(id);
        return ResponseEntity.ok(jobAddById);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobAdvertisements(@PathVariable Long id){
        jobAdvertisementService.deleteJobAdvertisementById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JobAdvertisementDto> addNewJobAdvertisements(@RequestBody JobAdvertisement jobAdvertisement){
        jobAdvertisementService.addNewJobAdvertisement(jobAdvertisement);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/city/{name}")
    public ResponseEntity<List<JobAdvertisementDto>> findAllJobsAdsByCity(@PathVariable String name){
        var jobsByCity = jobAdvertisementService.findAllJobAdvertisementByCity(name);
        return ResponseEntity.ok(jobsByCity);
    }

    @GetMapping("/state/{name}")
    public ResponseEntity<List<JobAdvertisementDto>> findAllJobsByState(@PathVariable String name){
        var jobsAdsByState =  jobAdvertisementService.findAllJobAdvertisementByState(name);
        return ResponseEntity.ok(jobsAdsByState);
    }

    @PutMapping
    public ResponseEntity<Void> updateJobAdds(@PathVariable Long id , @RequestBody JobAdvertisement jobAdvertisement){
      jobAdvertisementService.updateJobAdvertisement(id,jobAdvertisement);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/company/{name}")
    public ResponseEntity<List<JobAdvertisementDto>> findAllJobsAdsByComponyName(@PathVariable String name){
        var byCompanyName = jobAdvertisementService.findAllJobAdvertisementByCompanyName(name);
        return ResponseEntity.ok(byCompanyName);
    }
}
