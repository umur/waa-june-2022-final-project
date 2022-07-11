package alumnimanagement.dto;

import alumnimanagement.entity.Student;
import alumnimanagement.entity.job.JobAdvertisement;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppliedJobDTO {

    private LocalDateTime appliedDate;
    private Boolean isActive;
    private Boolean isDeleted;
    private long id_student;
    private String additionalComment;
    private int id_job;
}
