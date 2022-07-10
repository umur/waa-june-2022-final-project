package alumnimanagement.dto;

import alumnimanagement.entity.helper.JobExperience;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class UpdateCVDTO {

    private String cvLink;

    private List<JobExperience> jobExperienceList;

}
