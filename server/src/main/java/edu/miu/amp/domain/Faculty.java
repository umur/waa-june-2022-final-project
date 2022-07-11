package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty extends User {
    @Id
    private Integer id;

    @ManyToOne
    private Department department;

    @OneToMany
    @JoinColumn(name = "faculty_id")
    private List<Comment> commentList;


}
