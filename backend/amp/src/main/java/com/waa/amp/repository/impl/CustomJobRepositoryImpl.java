package com.waa.amp.repository.impl;

import com.waa.amp.dto.JobSearchReq;
import com.waa.amp.entity.Job;
import com.waa.amp.repository.CustomJobRepository;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

import static com.waa.amp.utils.Utils.isNotBlank;

@RequiredArgsConstructor
public class CustomJobRepositoryImpl implements CustomJobRepository {

    private final EntityManager entityManager;

    @Override
    public List<Job> searchJob(JobSearchReq jobSearchReq) {
        String sql = " select * from job where 1 = 1 ";

        if (isNotBlank(jobSearchReq.tags())){
            // TODO tag search
        }
        if (isNotBlank(jobSearchReq.state())){
            sql += " and state = '" + jobSearchReq.state() + "'";
        }
        if (isNotBlank(jobSearchReq.city())){
            sql += " and city = '" + jobSearchReq.city() + "'";
        }
        if (isNotBlank(jobSearchReq.companyName())){
            sql += " and company_name = '" + jobSearchReq.companyName() + "'";
        }

        List<Job> resultList = (List<Job>) entityManager.createNativeQuery(sql, Job.class).getResultList();

        return resultList;
    }
}
