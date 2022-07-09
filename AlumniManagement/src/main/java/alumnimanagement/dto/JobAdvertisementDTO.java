package alumnimanagement.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class JobAdvertisementDTO {
    private int id;

    private String jobTitle;
    private String jobDesc;
    private String addBenefit;
    private String companyName;
    private LocalDateTime publishDate;

    //todo Address address;
    private AddressDTO addressDTO;
    private List<TagDTO> tags;
}
