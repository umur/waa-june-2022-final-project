package edu.miu.amp.dto;

import lombok.Data;

@Data
public class StudentDto extends UserDto {
//    private Integer id;

    private Float gpa;
    private String CVFile;
    private DepartmentDto department;
    private Integer daysToSearchJob;
}
