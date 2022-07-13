package com.waa.amp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class StudentComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    private Student student;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private List<Comment> comments = new ArrayList<>();

    public StudentComment(Student student, Comment comment) {
        this.student = student;
        this.comments.add(comment);
    }

    public void addComments(Comment comment) {
        comments.add(comment);
    }
}
