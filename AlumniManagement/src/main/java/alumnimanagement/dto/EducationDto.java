package alumnimanagement.dto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class EducationDto {
    private enum level{
        Masters, PHD
    }
    private String major;
    private Date yearCompleted;
    private String university;
}
