package alumnimanagement.entity;

import alumnimanagement.entity.job.JobAdvertisement;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class AppliedJob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime appliedDate;
    private Boolean isActive;
    private Boolean isDeleted;
    private String additionalComment;

    @OneToOne()
    @JoinColumn(name = "id_student")
    private Student student;

    @OneToOne
    @JoinColumn(name = "id_job")
    private JobAdvertisement jobAdvertisement;

}
