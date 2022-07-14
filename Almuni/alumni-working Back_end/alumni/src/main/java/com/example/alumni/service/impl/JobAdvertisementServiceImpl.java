package com.example.alumni.service.impl;


import com.example.alumni.dto.JobAdvertisementDto;
import com.example.alumni.entity.JobAdvertisement;
import com.example.alumni.repository.IJobAdvertisementRepository;
import com.example.alumni.service.IJobAdvertisementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class JobAdvertisementServiceImpl implements IJobAdvertisementService {

    @Autowired
    private IJobAdvertisementRepository jobAdvertisementRepository;
    @Autowired
    private ModelMapper modelMapper;

    //todo getting all the jobs adds
    public List<JobAdvertisementDto> findAllJobAds(){

        var allJobs = jobAdvertisementRepository.findAll();
        List<JobAdvertisementDto> allJobsAdds =  new ArrayList<>();

         allJobs.forEach(job -> {
            allJobsAdds.add(modelMapper.map(job,JobAdvertisementDto.class));
        });
        return allJobsAdds;
    }
    // -> applied 10 recently jobs
    @Override
    public List<JobAdvertisementDto> findTenRecentlyAppliedJobs() {

        var allJobs = jobAdvertisementRepository.findAll();

        return allJobs.stream()
                .filter(applied -> applied.isApplied() == true)
                .map(jobs -> jobs.getAppliedDate())
                .sorted((s1,s2) -> s2.compareTo(s1))
                .limit(10)
                .map(dto -> modelMapper.map(dto,JobAdvertisementDto.class))
                .collect(Collectors.toList());
    }
    // -> applied for a job
    @Override
    public void appliedNewJob(Long id) {
        var newAppliedJob = jobAdvertisementRepository.findById(id).get();
        newAppliedJob.setApplied(true);
        newAppliedJob.setAppliedDate(LocalDate.now());
    }
    // -> adding / posting new job
    @Override
    public void addNewJobAdvertisement(JobAdvertisement jobAdvertisement) {
        var newJobAdd = jobAdvertisement;
        newJobAdd.setPostedDate(LocalDate.now());
        jobAdvertisementRepository.save(newJobAdd);
    }

    //todo searching jobs advertisements by id
    @Override
    public JobAdvertisementDto findJobAdvertisementById(Long id) {

        var jobById = jobAdvertisementRepository.findById(id).get();
        return modelMapper.map(jobById,JobAdvertisementDto.class);
    }

    //todo delete by id
    @Override
    public void deleteJobAdvertisementById(Long id) {
        jobAdvertisementRepository.deleteById(id);
    }

    // -> last 10 job advertisements
    @Override
    public List<JobAdvertisementDto> getLastTenJobAdvertisements() {

        List<JobAdvertisement> allJobs = jobAdvertisementRepository.findAll();
        List<JobAdvertisementDto> topTen = new ArrayList<>();

        return allJobs.stream()
                .map(JobAdvertisement::getPostedDate)
                .sorted((s1,s2) -> s2.compareTo(s1))
                .limit(10)
                .map(job -> modelMapper.map(job, JobAdvertisementDto.class))
                .collect(Collectors.toList());
    }

    //todo -> searching jobs advertisements by company name
    @Override
    public List<JobAdvertisementDto> findAllJobAdvertisementByCompanyName(String companyName) {
        var jobByCompany = jobAdvertisementRepository.getAllJobAdvertismentByCompanyName(companyName);

     return jobByCompany.stream()
             .map(jobs -> modelMapper.map(jobByCompany,JobAdvertisementDto.class))
             .collect(Collectors.toList());

    }

    // todo -> updating jobs advertisements
    @Override
    public void updateJobAdvertisement(Long id, JobAdvertisement jobAdvertisement) {

        var allJob = jobAdvertisementRepository.findAll();

        allJob.forEach(jobs -> {
            if(jobs.getId() == id){
                jobAdvertisementRepository.save(jobAdvertisement);
            } else {
                System.out.println("The job you want to update NOT FOUND");
            }
        });
    }

    // todo -> searching jobs advertisements by state
    @Override
    public List<JobAdvertisementDto> findAllJobAdvertisementByState(String state) {

        var allJobs = jobAdvertisementRepository.getAllJobAdvertismentByState(state);

        return allJobs.stream()
                .map(jobs -> modelMapper.map(jobs, JobAdvertisementDto.class))
                .collect(Collectors.toList());
    }

    //todo -> searching jobs advertisements by city name
    @Override
    public List<JobAdvertisementDto> findAllJobAdvertisementByCity(String city) {

        var allJobs = jobAdvertisementRepository.getAllJobAdvertismentByCity(city);

        return allJobs.stream()
                .map(jobs -> modelMapper.map(jobs,JobAdvertisementDto.class))
                .collect(Collectors.toList());
    }


}
