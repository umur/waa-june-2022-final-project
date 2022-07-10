package com.finalproject.service;

import com.finalproject.models.JobAdvertisement;

import java.util.List;

public interface JobService {
    List<JobAdvertisement> findAll();
}
