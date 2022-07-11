package com.waa.amp.controller;

import com.waa.amp.dto.CommentReq;
import com.waa.amp.dto.StudentSearchReq;
import com.waa.amp.entity.Student;
import com.waa.amp.service.CommentService;
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
@CrossOrigin
public class FacultyController {

    private final CommentService commentService;
    private final StudentService studentService;

    @PostMapping("/post-comment")
    public ResponseEntity<Map<String, Long>> postComment(@RequestBody CommentReq commentReq){
        return ResponseEntity.ok(
                of("commentId", commentService.postComment(commentReq))
        );
    }

    @PostMapping("/search-student")
    public ResponseEntity<Map<String, List<Student>>> searchStudent(@RequestBody StudentSearchReq studentSearchReq) {
        return ResponseEntity.ok(of("resutls", studentService.searchStudent(studentSearchReq)));
    }

}
