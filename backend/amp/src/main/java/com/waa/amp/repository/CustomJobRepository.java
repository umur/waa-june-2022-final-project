package com.waa.amp.repository;

import com.waa.amp.dto.JobSearchReq;
import com.waa.amp.entity.Job;

import java.util.List;

public interface CustomJobRepository {
    List<Job> searchJob(JobSearchReq jobSearchReq);
}
