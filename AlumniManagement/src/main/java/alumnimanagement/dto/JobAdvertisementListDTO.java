package alumnimanagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobAdvertisementListDTO {
    private int id;

    private String jobTitle;
    private String jobDesc;
    private String addBenefit;
    private String companyName;
    private String companySize;
    private int numOpening;
    private String jobType;
    private float paymentAmount;
    private LocalDateTime publishDate;

    private String state;
    private String city;
    private String tag;
}
