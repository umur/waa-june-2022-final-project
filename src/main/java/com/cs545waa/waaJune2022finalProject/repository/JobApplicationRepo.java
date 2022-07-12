package com.cs545waa.waaJune2022finalProject.repository;

import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobApplicationRepo extends CrudRepository<JobAdvertisement,Integer> {

    @Query(value ="select description,benefits from job_advertisement\n" +
            "  where id  in ( SELECT\n" +
            "  job_applications_id\n" +
            "   FROM job_application\n" +
            "   GROUP BY\n" +
            "   job_applications_id\n" +
            "  ORDER BY COUNT( job_applications_id) DESC limit 10)",nativeQuery = true)
    List<JobAdvertisement> getJobAdvByMostRecentApplied();
}
