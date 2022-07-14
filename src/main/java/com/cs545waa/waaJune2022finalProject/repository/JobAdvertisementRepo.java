package com.cs545waa.waaJune2022finalProject.repository;

import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAdvertisementRepo extends PagingAndSortingRepository<JobAdvertisement,Integer> {
}
