package com.finalproject.service;

import com.finalproject.models.JobAdvertisement;
import com.finalproject.models.Student;

import java.util.List;

public interface JobService {
    List<JobAdvertisement> findAll();
    List<JobAdvertisement>findRecent();
    List<JobAdvertisement>findRecentApplied();
    List<JobAdvertisement>findByCity(String city);
    List<JobAdvertisement>findByState(String states);
    List<JobAdvertisement>findByCompany(String company);
    void postJobAdvert(JobAdvertisement jobAdvertisement, Student student  );

}
