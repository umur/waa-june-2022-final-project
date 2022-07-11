package com.waa.amp.controller;

import com.waa.amp.dto.JobReq;
import com.waa.amp.entity.Job;
import com.waa.amp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.Map.of;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/post-job")
    public ResponseEntity<Job> postJob(@RequestBody JobReq jobReq) {
        return ResponseEntity.ok(studentService.postJob(jobReq));
    }

    @GetMapping("/get-job")
    public ResponseEntity<Map<String, List<Job>>> getJob() {
        return ResponseEntity.ok(of("jobList", studentService.getJob()));
    }
}
