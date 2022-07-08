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

    //todo Address address;
    private List<TagDTO> tags;
}
