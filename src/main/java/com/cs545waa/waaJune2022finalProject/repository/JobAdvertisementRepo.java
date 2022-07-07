package com.cs545waa.waaJune2022finalProject.repository;

import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAdvertisementRepo extends CrudRepository<JobAdvertisement, Integer> {
}
