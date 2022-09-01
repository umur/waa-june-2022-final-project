package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE student SET is_delete = true WHERE id=?")
@Where(clause = "is_delete = false")
public class Student extends User {
    @Id
    private Integer id;

    @Nullable
    private Float gpa;

    @Nullable
    private String CVFile;

    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    @OneToMany(mappedBy = "createdBy")
    private List<JobAdvertisement> jobAdvertisementList;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name="student_id")
    private List<JobHistory> jobHistoryList;

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Comment> commentList;

    @Column(name = "is_delete")
    private boolean delete;

    @Column(name="days_to_search_job")
    private Integer daysToSearchJob;
}
