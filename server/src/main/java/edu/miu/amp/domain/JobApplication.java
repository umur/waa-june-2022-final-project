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
@SQLDelete(sql = "UPDATE job_application SET deleted = true where id = ?")
@Where(clause = "deleted=false")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "job_Advertisement_id")
    private JobAdvertisement jobAdvertisement;

    @ManyToMany
    private List<Student> studentList;

    private boolean deleted;

    @Column(name = "job_applied_date")
    private LocalDate jobAppliedDate;
}
