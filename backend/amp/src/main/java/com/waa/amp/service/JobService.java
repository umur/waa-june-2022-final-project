package com.waa.amp.service;

import com.waa.amp.dto.JobSearchReq;
import com.waa.amp.entity.Job;
import com.waa.amp.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public List<Job> searchJob(JobSearchReq jobSearchReq) {
        return jobRepository.searchJob(jobSearchReq);
    }
}
