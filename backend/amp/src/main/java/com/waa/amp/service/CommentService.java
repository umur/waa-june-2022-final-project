package com.waa.amp.service;

import com.waa.amp.dto.CommentReq;
import com.waa.amp.entity.Comment;
import com.waa.amp.entity.JobComment;
import com.waa.amp.entity.Tag;
import com.waa.amp.repository.CommentRepository;
import com.waa.amp.repository.JobCommentRepository;
import com.waa.amp.repository.JobRepository;
import com.waa.amp.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final JobRepository jobRepository;
    private final JobCommentRepository jobCommentRepository;
    private final TagRepository tagRepository;

    public Long postComment(CommentReq commentReq) {
        var save = commentRepository.save(new Comment(null, commentReq.comment()));
        var job = jobRepository.findById(commentReq.jobId()).orElseThrow(() -> new RuntimeException("No Job Found"));
        JobComment jobComment = new JobComment(null, job, new Comment(commentReq.comment()));
        return jobCommentRepository.save(jobComment).getId();
    }

    public List<Tag> allTag() {
        return tagRepository.findAll();
    }
}
