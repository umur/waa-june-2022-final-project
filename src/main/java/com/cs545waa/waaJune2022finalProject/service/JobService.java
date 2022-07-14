package com.cs545waa.waaJune2022finalProject.service;

import com.cs545waa.waaJune2022finalProject.Exceptions.RecordNotFoundException;
import com.cs545waa.waaJune2022finalProject.dto.*;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobService {
    public List<ApplicantDTO> getApplicants(Integer jobId);
    public void advertiseJob();
    public void applyToJob(Integer jobId,String username);
    JobADvertismentGetDTO getById(int id);
    public List<JobAdvertisementDto> getJobAdvertisements(int limit, int offset);
    public List<JobAdvertisementDto> getAllJobAdvertisements(String username);
    Page<JobAdvertisement> getAllJobAdvPaginated(PagingRequest pagingRequest);

    List<JobAdvertisementDto> filter(String tag, String state, String city, String companyName);

    void saveJobAdvertisement(JobAdvertisement jobAdvertisement , MultipartFile file) throws RecordNotFoundException;

    List<JobAdvertisement> getJobAdvByMostRecentApplied();

    void deleteEmployeeById(Integer id) throws RecordNotFoundException;
    List<TagCount> countTotalTagsByName();

    List<JobCount> countTotalJobsByCompanyName();
}
