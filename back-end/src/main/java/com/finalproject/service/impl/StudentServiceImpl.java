package com.finalproject.service.impl;

import com.finalproject.models.Comments;
import com.finalproject.models.ERole;
import com.finalproject.models.User;
import com.finalproject.payload.request.PostRequest;
import com.finalproject.repository.CommentRepo;
import com.finalproject.repository.StudentRepo;
import com.finalproject.repository.UserRepository;
import com.finalproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Override
    public List<User> findAllStudent() {
        List<User> allUserStudents = new ArrayList<>();
        userRepo.findAll().forEach(user -> {
            ERole role = user.getRoles().stream().toList().get(0).getName();
            if (role == ERole.ROLE_STUDENT) {
                allUserStudents.add(user);
            }
        });
        return allUserStudents;
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("Error: User not found"));
    }

    @Override
    public void post(PostRequest postRequest, long id) {
        var student = studentRepo.findById(id).orElseThrow(()-> new RuntimeException("Error: Student not found."));
        Comments comment = new Comments();
        comment.setComment(postRequest.getComment());
        comment.setCommenter(postRequest.getCommenter());
        comment.setPostTime(LocalDateTime.now());
        comment.setStudent(student);
        commentRepo.save(comment);
    }
}
