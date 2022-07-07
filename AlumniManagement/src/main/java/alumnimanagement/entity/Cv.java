package alumnimanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cv {
    @Id
    @GeneratedValue
    private long id;
    private String summary;
    private String skills;
    private String languages;
    @OneToMany
    private List<Education> educationList;
    @OneToMany
    private List<Experience> experienceList;
}
