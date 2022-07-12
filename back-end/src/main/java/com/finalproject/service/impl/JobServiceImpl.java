package com.finalproject.service.impl;

import com.finalproject.models.JobAdvertisement;
import com.finalproject.models.Student;
import com.finalproject.repository.AppliedRepository;
import com.finalproject.repository.JobRepo;
import com.finalproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepo jobRepo;

    @Autowired

    private AppliedRepository applied;

    @Override
    public List<JobAdvertisement> findAll() {
        List<JobAdvertisement> jobs = new ArrayList<>();
        jobRepo.findAll().forEach(job-> {
            jobs.add(job);
        });

        return jobs.stream().filter(o->o.isMark_delete()!=true).collect(Collectors.toList());
    }

    @Override
    public List<JobAdvertisement> findRecent() {
        List<JobAdvertisement> holder = new ArrayList<>();
        holder = jobRepo.findAllByPostedDate().stream().filter(k -> k.isMark_delete() != true).limit(10).collect(Collectors.toList());
        System.out.println(holder);
        return holder;
    }

    @Override
    public JobAdvertisement getById(Long id) {
        return jobRepo.findById(id).orElseThrow();
    }



    @Override
    public List<JobAdvertisement> findByCity(String city) {
        List<JobAdvertisement> holder =new ArrayList<>();
        holder =  jobRepo.findAllByCity(city).stream().filter(k->k.isMark_delete()!=true).collect(Collectors.toList());
        return holder;

    }

    @Override
    public List<JobAdvertisement> findByState(String states) {
        List<JobAdvertisement> holder =new ArrayList<>();
        holder =  jobRepo.findAllByStates(states).stream().filter(k->k.isMark_delete()!=true).collect(Collectors.toList());
        return holder;
    }

    @Override
    public List<JobAdvertisement> findAllByTag(String tag) {

        List<JobAdvertisement> holder =new ArrayList<>();
        holder =  jobRepo.findAllByTags_name(tag).stream().filter(k->k.isMark_delete()!=true).collect(Collectors.toList());
        return holder;


    }

    @Override
    public List<JobAdvertisement> findByCompany(String company) {
        List<JobAdvertisement> holder =new ArrayList<>();
      holder =  jobRepo.findAllByCompany(company).stream().filter(k->k.isMark_delete()!=true).collect(Collectors.toList());
      return holder;
    }

    @Override
    public void postJobAdvert(JobAdvertisement jobAdvertisement, Student st ) {
        jobAdvertisement.setStudent(st);
        jobRepo.save(jobAdvertisement);
    }

    @Override
    public void deleteJob(Student student) {

       if(student.getJobAdvertisement()!=null);{

         var n= student.getJobAdvertisement();
         n.setMark_delete(true);

        }

    }

    @Override
    public Integer countByState(String state) {
        return jobRepo.countAllByStates(state);
    }

    @Override
    public Integer countByCity(String city) {
        return jobRepo.countAllByCity(city);
    }


}
