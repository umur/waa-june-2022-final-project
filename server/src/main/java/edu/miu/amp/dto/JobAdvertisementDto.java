package edu.miu.amp.dto;

import lombok.Data;

@Data
public class JobAdvertisementDto {
    private Integer id;

    private String description;
    private String benefits;
    private String companyName;
}
