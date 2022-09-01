package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE job_history SET is_delete = true WHERE id=?")
@Where(clause = "is_delete = false")
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "reason_to_leave")
    private String reasonToLeave;

    @Column(name = "comments")
    private String comment;

    @ManyToMany
    private List<Tag> tagsList;

    @Column(name = "is_delete")
    private boolean delete;
}
