package com.finalproject.service.impl;

import com.finalproject.models.JobAdvertisement;
import com.finalproject.repository.JobRepo;
import com.finalproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepo jobRepo;

    @Override
    public List<JobAdvertisement> findAll() {
        List<JobAdvertisement> jobs = new ArrayList<>();
        jobRepo.findAll().forEach(job-> {
            jobs.add(job);
        });
        return jobs;
    }
}
