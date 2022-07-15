package com.waa.amp.service;

import com.waa.amp.dto.CommentReq;
import com.waa.amp.entity.*;
import com.waa.amp.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final StudentCommentRepository studentCommentRepository;
    private final TagRepository tagRepository;
    private final UserService userService;
    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    public int postComment(CommentReq commentReq) {

        User loggedUser = userService.getLoggedUser();
        Faculty faculty = facultyRepository.findByUser(loggedUser);
        String name = faculty.getFirstname() + " " + faculty.getLastname();

        Student student = studentRepository.findById(commentReq.studentId()).orElse(null);

        Comment save = commentRepository.save(new Comment(commentReq.comment(), name));

        StudentComment byStudent = studentCommentRepository.findByStudent(student);

        if (byStudent == null) {
            byStudent = new StudentComment(student, save);
        } else {
            byStudent.addComments(save);
        }
        studentCommentRepository.save(byStudent);

        return byStudent.getComments().size();
    }

    public List<Comment> allComment(Long studentId) {
        StudentComment byStudent = studentCommentRepository.findByStudent(studentRepository.findById(studentId).orElse(null));
        return byStudent.getComments();
    }

    public List<Tag> allTag() {
        return tagRepository.findAll();
    }
}
