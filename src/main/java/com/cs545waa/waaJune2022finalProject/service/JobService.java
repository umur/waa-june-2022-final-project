package com.cs545waa.waaJune2022finalProject.service;

import com.cs545waa.waaJune2022finalProject.dto.ApplicantDTO;
import com.cs545waa.waaJune2022finalProject.dto.JobAdvertisementDto;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface JobService {
    public List<ApplicantDTO> getApplicants(Integer jobId);
    public void advertiseJob();
    public void applyToJob(Integer jobId,String username);
    public JobAdvertisementDto getJobById(Integer id);
    public List<JobAdvertisementDto> getJobAdvertisements(int limit, int offset);
    public List<JobAdvertisementDto> getJobAllAdvertisements();
    List<JobAdvertisementDto> filter(String tag, String state, String city, String companyName);
}
