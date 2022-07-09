package com.cs545waa.waaJune2022finalProject.controller;

import com.cs545waa.waaJune2022finalProject.dto.ApplicantDTO;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import com.cs545waa.waaJune2022finalProject.service.JobService;
import lombok.AllArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/job-applications")
@AllArgsConstructor
public class JobApplicationController {
    private final JobService jobService;

    //    -------------------- get applicants -------------------

    @GetMapping("/applicants")
    public List<ApplicantDTO> getApplicants(@RequestBody Integer jobId){
        return jobService.getApplicants(jobId);
    }


    //    -------------------- apply for a job -------------------
    @PostMapping("/apply")
    public void applyToJob(@RequestBody Integer jobId, Principal principal){

        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username=user.getKeycloakSecurityContext().getToken().getPreferredUsername();

        jobService.applyToJob(jobId,username);
    }

    //    -----------------------  get list of advertisements ---------
    @GetMapping
    public List<JobAdvertisement> getJobAdvertisements(int limit, int offset){
        return jobService.getJobAdvertisement(limit,offset);
    }
}
