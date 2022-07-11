package com.finalproject.service.impl;

import com.finalproject.models.JobAdvertisement;
import com.finalproject.models.Student;
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

    @Override
    public List<JobAdvertisement> findRecent() {
        return jobRepo.findAllRecentApplied(10);
    }

    @Override
    public List<JobAdvertisement> findRecentApplied() {
        return jobRepo.findAllRecentApplied(10);
    }

    @Override
    public List<JobAdvertisement> findByCity(String city) {
        return jobRepo.findAllByCity(city);
    }

    @Override
    public List<JobAdvertisement> findByState(String states) {
        return jobRepo.findAllByStates(states);
    }

    @Override
    public List<JobAdvertisement> findAllByTag(String tag) {
        return jobRepo.findAllByTags_name(tag);
    }

    @Override
    public List<JobAdvertisement> findByCompany(String company) {
        return jobRepo.findAllByCompany(company);
    }

    @Override
    public void postJobAdvert(JobAdvertisement jobAdvertisement, Student st ) {
        jobAdvertisement.setStudent(st);
        jobRepo.save(jobAdvertisement);
    }

    @Override
    public void deleteJob(Student student) {

        student.setJobAdvertisement(null);

    }
}
