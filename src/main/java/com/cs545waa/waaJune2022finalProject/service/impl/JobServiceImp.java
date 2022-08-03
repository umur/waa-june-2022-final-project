package com.cs545waa.waaJune2022finalProject.service.impl;

import com.cs545waa.waaJune2022finalProject.dto.ApplicantDTO;
import com.cs545waa.waaJune2022finalProject.dto.JobAdvertisementDto;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import com.cs545waa.waaJune2022finalProject.entity.JobApplication;
import com.cs545waa.waaJune2022finalProject.entity.Student;
import com.cs545waa.waaJune2022finalProject.repository.JobRepo;
import com.cs545waa.waaJune2022finalProject.repository.StudentRepo;
import com.cs545waa.waaJune2022finalProject.service.JobService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class JobServiceImp implements JobService {
    private final JobRepo jobRepo;
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<ApplicantDTO> getApplicants(Integer jobId) {
       return jobRepo.findById(jobId).get().getJobApplications()
                .stream()
                .map(applicant->modelMapper.map(applicant,ApplicantDTO.class))
               .collect(Collectors.toList());
    }

    @Override
    public void advertiseJob() {

    }
    @Override
    public void applyToJob(Integer jobId,String username){
        Student st = studentRepo.getStudentByUsername(username);
        JobAdvertisement job=jobRepo.findById(jobId).get();
        //job.getJobApplications().add(st);
        st.getJobApplications().add(new JobApplication(null,st,job));
    }

    @Override
    public JobAdvertisementDto getJobById(Integer id) {
        return modelMapper.map(jobRepo.findById(id).get(),JobAdvertisementDto.class);
    }

    @Override
    public List<JobAdvertisementDto> getJobAdvertisements(int limit, int offset) {
        // return 10 jobs
        return null;
    }
    @Override
    public List<JobAdvertisementDto> getJobAllAdvertisements() {
        // return 10 jobs
        List<JobAdvertisementDto> jobAdvertisementDtos=new ArrayList<>();
         jobRepo.findAll().forEach( jobAdvertisement -> {
            jobAdvertisementDtos.add(modelMapper.map(jobAdvertisement,JobAdvertisementDto.class));
        });
         return jobAdvertisementDtos;
    }

    @Override
    public List<JobAdvertisementDto> filter(String tag, String state, String city, String companyName) {
//        if(filter_param.equals(""))
//        @Query("SELECT jobs FROM JobAdvertisement WHERE")
        List<JobAdvertisement> jobs=jobRepo.findByFilter(tag, state, city, companyName);
        return jobRepo.findByFilter(tag, state, city, companyName).stream()
                .map(job->modelMapper.map(job,JobAdvertisementDto.class))
                .collect(Collectors.toList());
    }
}
