package com.example.almuni.service.impl;

import com.example.almuni.dto.JobAdvertisementDto;
import com.example.almuni.entity.JobAdvertisement;
import com.example.almuni.repository.JobAdvertisementRepository;
import com.example.almuni.service.JobAdvertisementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobAdvertisementServiceImpl implements JobAdvertisementService {

    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepository;
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

    @Override
    public void addNewJobAdvertisement(JobAdvertisement jobAdvertisement) {
        jobAdvertisementRepository.save(jobAdvertisement);
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

    //todo searching jobs advertisements by company name
    @Override
    public List<JobAdvertisementDto> findAllJobAdvertisementByCompanyName(String companyName) {
        var jobByCompany = jobAdvertisementRepository.getAllJobAdvertismentByCompanyName(companyName);

     return jobByCompany.stream()
             .map(jobs -> modelMapper.map(jobByCompany,JobAdvertisementDto.class))
             .collect(Collectors.toList());

    }

    // todo updating jobs advertisements
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

    // todo searching jobs advertisements by state
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
