package com.cs545waa.waaJune2022finalProject.service.impl;


import com.cs545waa.waaJune2022finalProject.dto.AdvertisementDto;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import com.cs545waa.waaJune2022finalProject.repository.JobAdvertisementRepo;
import com.cs545waa.waaJune2022finalProject.service.JobAdvertisementService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@AllArgsConstructor
@Data
@Transactional
public class JobAdvertisementServiceImpl implements JobAdvertisementService {

    JobAdvertisementRepo jobAdvertisementRepo;
    private final ModelMapper modelMapper = new ModelMapper();

    public AdvertisementDto createJobAdvertisement(AdvertisementDto advertisementDto) {
        JobAdvertisement jobAdvertisement =
                modelMapper.map(advertisementDto, JobAdvertisement.class);
        JobAdvertisement jobAdvertisementSaved = jobAdvertisementRepo.save(jobAdvertisement);
        return modelMapper.map(jobAdvertisementSaved, AdvertisementDto.class);
    }

}
