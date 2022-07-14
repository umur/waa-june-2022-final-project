package com.example.almuni.service;

import com.example.almuni.dto.JobAdvertisementDto;
import com.example.almuni.entity.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {

    List<JobAdvertisementDto> findAllJobAdvertisementByCompanyName(String companyName);
    void updateJobAdvertisement(Long id, JobAdvertisement jobAdvertisement);
    List<JobAdvertisementDto> findAllJobAdvertisementByState(String state);
    List<JobAdvertisementDto> findAllJobAdvertisementByCity(String city);
    void addNewJobAdvertisement(JobAdvertisement jobAdvertisement);
    JobAdvertisementDto findJobAdvertisementById(Long id);
    void deleteJobAdvertisementById(Long id);
    List<JobAdvertisementDto> findAllJobAds();

}
