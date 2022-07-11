package com.waa.amp.controller;

import com.waa.amp.dto.JobSearchReq;
import com.waa.amp.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/common")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class CommonController {

    private final JobService jobService;

    @PostMapping("/search-job")
    public ResponseEntity<?> studentSearch(@RequestBody JobSearchReq jobSearchReq) {
        return ResponseEntity.ok(Map.of("results", jobService.searchJob(jobSearchReq)));
    }

}
