package com.example.alumni.repository;


import com.example.alumni.dto.JobAdvertisementDto;
import com.example.alumni.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IJobAdvertisementRepository extends JpaRepository<JobAdvertisement, Long> {

    @Query("select jobAd from JobAdvertisement as jobAd where jobAd.address.state=?1")
    List<JobAdvertisement> getAllJobAdvertismentByState(String state);

    @Query("select jobAd from JobAdvertisement as jobAd where jobAd.address.city=?1")
    List<JobAdvertisement> getAllJobAdvertismentByCity(String City);

    List<JobAdvertisement> getAllJobAdvertismentByCompanyName(String companyName);



}
