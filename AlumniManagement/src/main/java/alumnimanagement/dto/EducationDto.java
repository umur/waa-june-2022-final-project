package alumnimanagement.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class EducationDto {
    private enum level{
        Masters, PHD
    }
    private String major;
    private Date yearCompleted;
    private String university;
}
