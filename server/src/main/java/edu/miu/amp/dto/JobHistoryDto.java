package edu.miu.amp.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class JobHistoryDto {
    private Integer id;

    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reasonToLeave;
    private String comment;
    private boolean delete;
}
