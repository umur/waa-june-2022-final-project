package com.cs545waa.waaJune2022finalProject.controller;

import com.cs545waa.waaJune2022finalProject.dto.AdvertisementDto;
import com.cs545waa.waaJune2022finalProject.service.impl.JobAdvertisementServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@Data
@AllArgsConstructor
public class JobAdvertisementController {
    JobAdvertisementServiceImpl jobAdvertisementService;

    // create job advertisement
    @PostMapping
    public AdvertisementDto createJobAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        return jobAdvertisementService.createJobAdvertisement(advertisementDto);

    }
}
