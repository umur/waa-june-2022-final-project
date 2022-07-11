package com.finalproject.controllers;

import com.finalproject.models.Applied;
import com.finalproject.models.JobAdvertisement;
import com.finalproject.models.Student;
import com.finalproject.security.services.UserDetailsImpl;
import com.finalproject.service.AppliedService;
import com.finalproject.service.JobService;
import com.finalproject.service.StudentService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
//@CrossOrigin(origins = "*")
public class JobsController {

    @Autowired
    JobService jobService;

    @Autowired
    AppliedService  appl;

    @Autowired

    private StudentService student;// new added


    // All the Job List

    @GetMapping
    public List<JobAdvertisement> findAll() {
        return jobService.findAll();
    }


    // pop out the recent added data
    @GetMapping("/addedrecent")
    public List<JobAdvertisement> RecentTenAdded() {
        return jobService.findRecent();
    }

// Addmin can see how many data of applied
    @GetMapping("/appliedjobs")
    public List<JobAdvertisement> RecentApplied() {

        return null;

    }
 //searching by city
    @GetMapping("/bycity")
    public List<JobAdvertisement> findAllByCity(@RequestParam String city) {

        return jobService.findByCity(city);
    }
  // searching by state
    @GetMapping("/byState")
    public List<JobAdvertisement> findAllByState(@RequestParam String state) {

        return jobService.findByState(state);
    }
// searching by tag
    @GetMapping("/bytag")
    public List<JobAdvertisement> findAllByTag(@RequestParam String tag) {

        return jobService.findAllByTag(tag);
    }
  // searching by company name
    @GetMapping("/Company")
    public List<JobAdvertisement> findAllByCompanyName(@RequestParam String name) {

        return jobService.findByCompany(name);
    }


    // student can make advertisement
    @PostMapping("/save")
    public void createJobAdvert(@RequestBody JobAdvertisement jobOpening) throws Exception {

        Object pr = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (pr instanceof UserDetailsImpl) {
            Long studentId = ((UserDetailsImpl) pr).getId();
            var n = student.getbyId(studentId);
            jobService.postJobAdvert(jobOpening, n);

        }
    }




//     updating advertisement

    @PutMapping
    public void updateJobOpening(@RequestBody JobAdvertisement job) throws Exception {
        Object pr = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (pr instanceof UserDetailsImpl) {
            Long studentId = ((UserDetailsImpl) pr).getId();
            var n = student.getbyId(studentId);
            jobService.postJobAdvert(job, n);

        }
    }


    // deleting advertisement
    @DeleteMapping
    public void deleteJobOpening(@RequestParam Long id) throws Exception {
        Object pr = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (pr instanceof UserDetailsImpl) {
            Long studentId = ((UserDetailsImpl) pr).getId();
            var n = student.getbyId(studentId);
            jobService.deleteJob(n);
        }
    }

    // applied completed   from get the  id from the  current pressed  job

    // forward to this link
    @PostMapping("/apply/{id}")
    public void applyJobAdvert(@PathVariable long id, @RequestBody Applied applied) {

       var  g  = jobService.getById(id);

       appl.ApplyJob(applied,g);

    }
}
