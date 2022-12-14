package alumnimanagement.dto;


import lombok.Data;

import java.util.Date;

@Data
public class ExperienceDto {
    private int id;
    private String companyName;
    private Date startDate;
    private Date endDate;
    private String position;
    private String summary;
}
