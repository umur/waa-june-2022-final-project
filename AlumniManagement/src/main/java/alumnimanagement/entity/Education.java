package alumnimanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Education {
    @Id
    @GeneratedValue
    private int id;
    private enum level{
        Masters, PHD
    }
    private String major;
    @Temporal(TemporalType.DATE)
    private Date yearCompleted;
    private String university;

}
