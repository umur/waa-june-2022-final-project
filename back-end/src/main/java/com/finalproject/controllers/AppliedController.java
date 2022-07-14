package com.finalproject.controllers;

import com.finalproject.models.Applied;
import com.finalproject.models.JobAdvertisement;
import com.finalproject.service.AppliedService;
import com.finalproject.service.impl.AppliedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AppliedController {

    @Autowired
private AppliedService appliedService;

    @GetMapping("/recentApplied")
    public List<Applied> RecentApplied() {

        return appliedService.recentApplied() ;

    }
}
