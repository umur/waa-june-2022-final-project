package alumnimanagement.entity.helper;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@ToString
@Entity
public class JobExperience {
    @Id
    @GeneratedValue
    private long id;
    private String companyName;
    private String detail;
}
