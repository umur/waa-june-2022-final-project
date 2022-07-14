package com.cs545waa.waaJune2022finalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobADvertismentGetDTO {
    private Integer id;
    private String companyName;
    private String description;
    private String benefits;



}
