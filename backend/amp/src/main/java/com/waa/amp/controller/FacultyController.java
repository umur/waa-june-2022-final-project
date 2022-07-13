package com.waa.amp.controller;

import com.waa.amp.dto.CommentReq;
import com.waa.amp.dto.StatRes;
import com.waa.amp.dto.StudentSearchReq;
import com.waa.amp.entity.Job;
import com.waa.amp.entity.Student;
import com.waa.amp.service.CommentService;
import com.waa.amp.service.JobService;
import com.waa.amp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.Map.of;

@RestController
@RequestMapping("/api/v1/faculty")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FacultyController {

    private final CommentService commentService;
    private final StudentService studentService;
    private final JobService jobService;

    @PostMapping("/post-comment")
    public ResponseEntity<Map<String, Integer>> postComment(@RequestBody CommentReq commentReq){
        commentService.postComment(commentReq);
        return ResponseEntity.ok(
                of("data", commentService.postComment(commentReq))
        );
    }

    @GetMapping("/get-comment/{studentId}")
    public ResponseEntity<?> getComment(@PathVariable Long studentId) {
        return ResponseEntity.ok(commentService.allComment(studentId));
    }

    @PostMapping("/search-student")
    public ResponseEntity<Map<String, List<Student>>> searchStudent(@RequestBody StudentSearchReq studentSearchReq) {
        return ResponseEntity.ok(of("data", studentService.searchStudent(studentSearchReq)));
    }

    @GetMapping("/all-student")
    public ResponseEntity<Map<String, List<Student>>> allStudent() {
        return ResponseEntity.ok(of("data", studentService.allStudent()));
    }

    @GetMapping("/stat")
    public ResponseEntity<StatRes> getStat() {
        return ResponseEntity.ok(jobService.stat());
    }

    @GetMapping("/get-job")
    public ResponseEntity<Map<String, List<Job>>> getJob() {
        return ResponseEntity.ok(of("jobList", studentService.getALlJob()));
    }
}
