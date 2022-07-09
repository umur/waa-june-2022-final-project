package alumnimanagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class JobAdvertisementDTO {
    private int id;

    private String jobTitle;
    private String jobDesc;
    private String addBenefit;
    private String companyName;
    private String companySize;
    private int numOpening;
    private String jobType;
    private float paymentAmount;

    //todo Address address;
    private List<TagDTO> tags;
}
