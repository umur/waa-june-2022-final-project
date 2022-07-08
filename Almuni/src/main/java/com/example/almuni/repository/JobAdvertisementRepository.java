package com.example.almuni.repository;

import com.example.almuni.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends CrudRepository<JobAdvertisement, Long> {

    @Query("select jobAd from JobAdvertisement as jobAd where jobAd.address.state=?1")
    List<JobAdvertisement> getAllJobAdvertismentByState(String state);
    @Query("select jobAd from JobAdvertisement as jobAd where jobAd.address.city=?1")
    List<JobAdvertisement> getAllJobAdvertismentByCity(String City);

    List<JobAdvertisement> getAllJobAdvertismentByCompanyName(String companyName);
}
