package com.cs545waa.waaJune2022finalProject.service.impl;

import com.cs545waa.waaJune2022finalProject.Exceptions.RecordNotFoundException;
import com.cs545waa.waaJune2022finalProject.dto.*;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import com.cs545waa.waaJune2022finalProject.entity.JobApplication;
import com.cs545waa.waaJune2022finalProject.entity.JobAttachment;
import com.cs545waa.waaJune2022finalProject.entity.Student;
import com.cs545waa.waaJune2022finalProject.repository.JobAdvertisementRepo;
import com.cs545waa.waaJune2022finalProject.repository.JobApplicationRepo;
import com.cs545waa.waaJune2022finalProject.repository.JobRepo;
import com.cs545waa.waaJune2022finalProject.repository.StudentRepo;
import com.cs545waa.waaJune2022finalProject.service.JobAttachmentService;
import com.cs545waa.waaJune2022finalProject.service.JobService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class JobServiceImp implements JobService {
    private final JobRepo jobRepo;
    private final JobAdvertisementRepo jobAdvertisementRepo;
    private final JobApplicationRepo jobApplicationRepo;
    JobAttachmentService jobAttachmentService;
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
    public JobADvertismentGetDTO getById(int id) {
        return modelMapper.map(jobRepo.findById(id), JobADvertismentGetDTO.class);

    }
//
//    @Override
//    public JobAdvertisementDto getJobById(Integer id) {
//        return modelMapper.map(jobRepo.findById(id).get(),JobAdvertisementDto.class);
//    }

    @Override
    public List<JobAdvertisementDto> getJobAdvertisements(int limit, int offset) {
        // return 10 jobs
        return null;
    }
    @Override
    public List<JobAdvertisementDto> getAllJobAdvertisements(String username) {
        // return 10 jobs
         return jobRepo.getJobAdvertisementByStudent(studentRepo.getStudentByUsername(username))
                 .stream()
                 .map(ad->modelMapper.map(ad,JobAdvertisementDto.class))
                 .collect(Collectors.toList());
    }

    @Override
    public Page<JobAdvertisement> getAllJobAdvPaginated(PagingRequest pagingRequest) {
        var direction = (pagingRequest.isAscending()) ? Sort.Direction.ASC : Sort.Direction.DESC;

        var request = PageRequest
                .of(pagingRequest.getPage(), pagingRequest.getPageSize(), direction,pagingRequest.getSortBy());

        return jobAdvertisementRepo.findAll(request);
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

    @Override
    public void saveJobAdvertisement(JobAdvertisement jobAdvertisement, MultipartFile file) throws RecordNotFoundException {
        Optional<JobAdvertisement> jobAdv = jobAdvertisementRepo.findById(jobAdvertisement.getId());

        if(!jobAdv.isPresent())
        {
            JobAdvertisement newJobAdvertisement = new JobAdvertisement();
//            newJobAdvertisement = jobAdv.get();
//
//            newJobAdvertisement.setDescription(jobAdvertisement.getDescription());
//            newJobAdvertisement.setBenifits(jobAdvertisement.getBenifits());
//            newJobAdvertisement.setCreatedDate(jobAdvertisement.getCreatedDate());
//            newJobAdvertisement.setTags(jobAdvertisement.getTags());

            newJobAdvertisement = jobAdvertisementRepo.save(jobAdvertisement);
            JobAttachment jb = jobAttachmentService.save(newJobAdvertisement.getId(), file);
            newJobAdvertisement.setJobAttachments(Arrays.asList(jb));





        } else {


            jobAdvertisementRepo.save(jobAdvertisement);
        }
    }

    @Override
    public List<JobAdvertisement> getJobAdvByMostRecentApplied() {
        return jobApplicationRepo.getJobAdvByMostRecentApplied();
    }

    @Override
    public void deleteEmployeeById(Integer id) throws RecordNotFoundException {
        Optional<JobAdvertisement> jobAdvertisement = jobAdvertisementRepo.findById(id);

        if(jobAdvertisement.isPresent()) {
            jobAdvertisementRepo.deleteById(id);

        } else {
            throw new RecordNotFoundException("No Job Advertisements  record exist for given id");

        }
    }


    ///////////////////////////////////////////
    @Override
    public List<TagCount> countTotalTagsByName() {
        return jobRepo.countTotalTagsByName();
    }

    @Override
    public List<JobCount> countTotalJobsByCompanyName() {

        return jobRepo.countTotalJobsByCompanyName();
    }
}
