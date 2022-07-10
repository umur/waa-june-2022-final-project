package alumnimanagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobAdvertisementListDTO {
    private int id;

    private String jobTitle;
    private String jobDesc;
    private String companyName;
    private int numOpening;
    private String jobType;
    private LocalDateTime publishDate;
    private String state;
    private String tag;
}
