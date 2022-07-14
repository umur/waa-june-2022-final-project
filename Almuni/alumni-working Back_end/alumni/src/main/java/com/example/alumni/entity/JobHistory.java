package com.example.alumni.entity;

import lombok.Data;
//import org.aspectj.apache.bcel.generic.Tag;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class JobHistory {

    private String companyName;
    private String reasonToLeave;
    private String comments;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Tag> tags;

}
