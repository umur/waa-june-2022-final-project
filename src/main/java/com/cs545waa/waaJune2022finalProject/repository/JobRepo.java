package com.cs545waa.waaJune2022finalProject.repository;

import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import org.springframework.data.repository.CrudRepository;

public interface JobRepo extends CrudRepository<JobAdvertisement,Integer> {
}
