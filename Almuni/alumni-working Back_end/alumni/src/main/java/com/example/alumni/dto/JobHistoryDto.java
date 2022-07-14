package com.example.alumni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.aspectj.apache.bcel.generic.Tag;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobHistoryDto {

    private String companyName;
    private String reasonToLeave;
    private String comments;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


}
