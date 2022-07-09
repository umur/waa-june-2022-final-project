package com.cs545waa.waaJune2022finalProject.controller;

import com.cs545waa.waaJune2022finalProject.dto.JobAdvertisementDto;
import com.cs545waa.waaJune2022finalProject.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobAdvertisementController {

    private final JobService jobService;


    //------------------------------ filter job advertisement  -------------

    @GetMapping("/filter/")
    public List<JobAdvertisementDto> filter(@RequestParam(name = "tag", required = false) String tag,
                                            @RequestParam(name = "state",required = false) String state,
                                            @RequestParam(name = "city", required = false) String city,
                                            @RequestParam(name = "companyName", required = false) String companyName) {

        return jobService.filter(tag, state, city, companyName);
    }

}
