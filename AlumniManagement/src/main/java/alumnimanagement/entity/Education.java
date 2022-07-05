package alumnimanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Education {
    @Id
    @GeneratedValue
    private long id;
    private enum level{
        Masters, PHD
    }
    private String major;
    @Temporal(TemporalType.DATE)
    private Date yearCompleted;
    private String university;

}
