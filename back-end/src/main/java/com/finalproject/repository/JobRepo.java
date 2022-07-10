package com.finalproject.repository;

import com.finalproject.models.JobAdvertisement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends CrudRepository<JobAdvertisement, Long> {
}
