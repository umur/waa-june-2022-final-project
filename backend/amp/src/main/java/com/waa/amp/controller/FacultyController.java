package com.waa.amp.controller;

import com.waa.amp.dto.CommentReq;
import com.waa.amp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.util.Map.of;

@RestController
@RequestMapping("/api/v1/faculty")
@RequiredArgsConstructor
@CrossOrigin
public class FacultyController {

    private final CommentService commentService;

    @PostMapping("/post-comment")
    public ResponseEntity<Map<String, Long>> postComment(@RequestBody CommentReq commentReq){
        return ResponseEntity.ok(
                of("commentId", commentService.postComment(commentReq))
        );
    }

}
