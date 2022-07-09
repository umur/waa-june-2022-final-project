package com.cs545waa.waaJune2022finalProject.service;

import com.cs545waa.waaJune2022finalProject.dto.ApplicantDTO;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;

import java.util.List;

public interface JobService {
    public List<ApplicantDTO> getApplicants(Integer jobId);
    public void advertiseJob();
    public void applyToJob(Integer jobId,String username);

    public List<JobAdvertisement> getJobAdvertisement(int limit, int offset);
}
