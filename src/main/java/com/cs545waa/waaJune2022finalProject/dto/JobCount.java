package com.cs545waa.waaJune2022finalProject.dto;

import lombok.Data;

@Data
public class JobCount {
    private String companyname;
    private Long total;

    public JobCount(String companyname, Long total) {
        this.companyname = companyname;
        this.total = total;
    }
}
