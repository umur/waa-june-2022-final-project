package alumnimanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Experience {
    @Id
    @GeneratedValue
    private long id;
    private String companyName;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String position;
    private String summary;
}
