package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {
    @Id
    private Integer id;

    @Nullable
    private Float gpa;

    @Nullable
    private String CVFile;

    @ManyToOne/**/
    private Department department;

    @OneToMany(mappedBy = "createdBy")
    private List<JobAdvertisement> jobAdvertisementList;

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Comment> commentList;

}
