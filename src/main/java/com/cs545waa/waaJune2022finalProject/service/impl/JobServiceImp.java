package com.cs545waa.waaJune2022finalProject.service.impl;

import com.cs545waa.waaJune2022finalProject.dto.ApplicantDTO;
import com.cs545waa.waaJune2022finalProject.dto.JobAdvertisementDto;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import com.cs545waa.waaJune2022finalProject.entity.Student;
import com.cs545waa.waaJune2022finalProject.repository.JobRepo;
import com.cs545waa.waaJune2022finalProject.repository.StudentRepo;
import com.cs545waa.waaJune2022finalProject.service.JobService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobServiceImp implements JobService {
    private final JobRepo jobRepo;
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<ApplicantDTO> getApplicants(Integer jobId) {
       return jobRepo.findById(jobId).get().getStudents()
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
        jobRepo.findById(jobId).get().getStudents().add(st);
    }

    @Override
    public List<JobAdvertisement> getJobAdvertisement(int limit, int offset) {
        // return 10 jobs
        return null;
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
