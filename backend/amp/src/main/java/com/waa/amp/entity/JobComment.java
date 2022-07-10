package com.waa.amp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class JobComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Faculty commentedBy;

    @OneToOne
    private Job job;

    @OneToMany
    @JoinColumn
    private List<Comment> comments = new ArrayList<>();

    public JobComment(Faculty commentedBy, Job job, Comment comment) {
        this.commentedBy = commentedBy;
        this.job = job;
        this.comments.add(comment);
    }
}
