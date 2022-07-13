package edu.miu.amp.dto;

import edu.miu.amp.domain.Address;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class JobAdvertisementDto {
    private Integer id;
    private String description;
    private String benefits;
    private String title;
    private String companyName;
    private Address address;
    private List<TagDto> tags;
    private LocalDate vacancyOpeningDate;
}
