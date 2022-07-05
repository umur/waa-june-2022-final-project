package alumnimanagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class JobAdvertisementDTO {
    private int id;

    private String title;
    private String description;
    private String benefits;
    private String companyName;

    //todo Address address;
    private List<TagDTO> tags;
}
