package alumnimanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Experience {
    @Id
    @GeneratedValue
    private int id;
    private String companyName;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String position;
    private String summary;
}
