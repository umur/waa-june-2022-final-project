package alumnimanagement.dto;

import alumnimanagement.entity.Student;
import alumnimanagement.entity.job.JobAdvertisement;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppliedJobDTO {
    private long id;
    private LocalDateTime appliedDate;
    private Boolean isActive;
    private Boolean isDeleted;
    private Student student;
    private JobAdvertisement jobAdvertisement;
}
