package com.example.almuni.repository;

import com.example.almuni.entity.Faculty;
import com.example.almuni.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepo extends JpaRepository<Faculty,Long> {
//    List<JobAdvertisement> getAllJobAdvertismentByState(String state);
//    List<JobAdvertisement> getAllJobAdvertismentByCity(String City);
//    List<JobAdvertisement> getAllJobAdvertismentByCompanyName(String companyName);
}
