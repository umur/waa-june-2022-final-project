package com.example.almuni.service;

import com.example.almuni.Dto.JobAdvertisementDto;
import com.example.almuni.entity.JobAdvertisement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IJobAdvertisementService {
    ResponseEntity<JobAdvertisementDto> add(JobAdvertisementDto jobAdvertisementDto);
    ResponseEntity<List<JobAdvertisementDto>> getAll(JobAdvertisementDto jobAdvertisementDto);
//    ResponseEntity<JobAdvertisementDto>

}
