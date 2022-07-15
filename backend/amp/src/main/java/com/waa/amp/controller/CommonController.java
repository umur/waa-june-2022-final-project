package com.waa.amp.controller;

import com.waa.amp.dto.JobSearchReq;
import com.waa.amp.dto.StudentReq;
import com.waa.amp.entity.Job;
import com.waa.amp.entity.Tag;
import com.waa.amp.service.CommentService;
import com.waa.amp.service.JobService;
import com.waa.amp.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.Map.of;

@RestController
@RequestMapping("/api/v1/common")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
public class CommonController {

    private final JobService jobService;
    private final CommentService commentService;
    private final StudentService studentService;

    @PostMapping("/search-job")
    public ResponseEntity<?> studentSearch(@RequestBody JobSearchReq jobSearchReq) {
        return ResponseEntity.ok(Map.of("results", jobService.searchJob(jobSearchReq)));
    }

    @GetMapping("/getAllTag")
    public ResponseEntity<Map<String, List<Tag>>> getTag() {
        return ResponseEntity.ok(of("tagList", commentService.allTag()));
    }

    @GetMapping("/get-job")
    public ResponseEntity<Map<String, List<Job>>> getJob() {
        return ResponseEntity.ok(of("jobList", studentService.getALlJob()));
    }

    @PostMapping("/update-profile")
    public ResponseEntity<?> updateProfile(@RequestBody StudentReq studentReq) {
        studentService.updateProfile(studentReq);
        return ResponseEntity.ok("data");
    }

    @GetMapping("/get-profile")
    public ResponseEntity<?> getProfile() {
        return ResponseEntity.ok(of("data", studentService.getProfile()));
    }

}
