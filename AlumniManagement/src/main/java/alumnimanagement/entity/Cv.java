package alumnimanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cv {
    @Id
    @GeneratedValue
    private int id;
    private String summary;
    private String skills;
    private String languages;
    @OneToMany
    private List<Education> educationList;
    @OneToMany
    private List<Experience> experienceList;
}
