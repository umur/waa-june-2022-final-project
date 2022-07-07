package alumnimanagement.dto;

import alumnimanagement.entity.Education;
import alumnimanagement.entity.Experience;
import lombok.Data;


import javax.persistence.OneToMany;
import java.util.List;

@Data
public class CvDto {
    private String summary;
    private String skills;
    private String languages;
    private List<Education> educationList;
    private List<Experience> experienceList;
}
