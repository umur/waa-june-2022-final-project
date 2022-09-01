package edu.miu.amp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobApplicationDto {
    private Integer id;
    private JobAdvertisementDto jobAdvertisement;
    private LocalDate jobAppliedDate;
}
