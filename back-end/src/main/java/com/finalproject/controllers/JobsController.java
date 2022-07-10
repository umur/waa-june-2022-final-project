package com.finalproject.controllers;

import com.finalproject.models.JobAdvertisement;
import com.finalproject.models.Student;
import com.finalproject.security.services.UserDetailsImpl;
import com.finalproject.service.JobService;
import com.finalproject.service.StudentService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
@CrossOrigin(origins = "*")
public class JobsController {

    @Autowired
    JobService jobService;

    @Autowired

    private StudentService student ;// new added

    @GetMapping
    public List<JobAdvertisement> findAll() {
        return jobService.findAll();
    }



//
    @GetMapping
    public List<JobAdvertisement> RecentTenAdded() {

        return jobService.findRecent();}



    @GetMapping("/applied")
    public List<JobAdvertisement> RecentApplied() {

        return null;

    }
    @GetMapping("/bycity")
    public List<JobAdvertisement> findAllByCity(@RequestParam String city) {

        return jobService.findByCity(city);}

    @GetMapping("/byState")
    public List<JobAdvertisement >findAllByState(String state) {

        return jobService.findByState(state);}

    @GetMapping("/bytag")
    public List<JobAdvertisement> findAllByTag(@RequestParam String  tag) {

        return null ;}
    @GetMapping("/Company")
    public List<JobAdvertisement> findAllByCompanyName(@RequestParam String name) {

        return jobService.findByCompany(name);}

    @PostMapping("/save")
    public void createJobAdvert(@RequestBody JobAdvertisement jobOpening) {

        Object pr = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (pr instanceof UserDetailsImpl) {
            Long studentId = ((UserDetailsImpl) pr).getId();
            var n = student.getbyId(studentId);
            jobService.postJobAdvert(jobOpening, n);

        }
    }
    @PutMapping
    public void updateJobOpening(@RequestBody JobAdvertisement job, Long id) {
        Object pr = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (pr instanceof UserDetailsImpl) {
            Long studentId = ((UserDetailsImpl) pr).getId();
            var n = student.getbyId(studentId);
            jobService.postJobAdvert(job, n);

        }
    }
    @DeleteMapping
    public void deleteJobOpening(@RequestParam Long id) {

    }
}
