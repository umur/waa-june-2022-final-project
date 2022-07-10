package alumnimanagement.dto;

import alumnimanagement.entity.helper.JobExperience;
import lombok.ToString;

import java.util.List;

@ToString
public class UpdateCVDTO {

    private String cvLink;

    private List<JobExperience> jobExperienceList;

}
