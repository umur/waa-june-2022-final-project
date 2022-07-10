package com.finalproject.controllers;

import com.finalproject.models.JobAdvertisement;
import com.finalproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
@CrossOrigin(origins = "*")
public class JobsController {

    @Autowired
    JobService jobService;

    @GetMapping
    public List<JobAdvertisement> findAll() {
        return jobService.findAll();
    }
}
