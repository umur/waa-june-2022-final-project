package alumnimanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    @Id
    @GeneratedValue
    private long id;
    private boolean isDeleted;
    private enum level{
        Masters, PHD
    }
    private String major;
    @Temporal(TemporalType.DATE)
    private Date yearCompleted;
    private String university;

}
