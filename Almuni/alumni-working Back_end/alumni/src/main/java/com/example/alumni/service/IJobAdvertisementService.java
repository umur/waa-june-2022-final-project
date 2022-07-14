package com.example.alumni.service;


import com.example.alumni.dto.JobAdvertisementDto;
import com.example.alumni.entity.JobAdvertisement;

import java.time.LocalDate;
import java.util.List;

public interface IJobAdvertisementService {

    List<JobAdvertisementDto> getLastTenJobAdvertisements();
    List<JobAdvertisementDto> findAllJobAdvertisementByCompanyName(String companyName);
    void updateJobAdvertisement(Long id, JobAdvertisement jobAdvertisement);
    List<JobAdvertisementDto> findAllJobAdvertisementByState(String state);
    List<JobAdvertisementDto> findAllJobAdvertisementByCity(String city);
    void addNewJobAdvertisement(JobAdvertisement jobAdvertisement);
    JobAdvertisementDto findJobAdvertisementById(Long id);
    void deleteJobAdvertisementById(Long id);
    List<JobAdvertisementDto> findAllJobAds();

    List<JobAdvertisementDto> findTenRecentlyAppliedJobs();

    void appliedNewJob(Long id);
}
