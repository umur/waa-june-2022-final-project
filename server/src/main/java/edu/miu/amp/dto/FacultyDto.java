package edu.miu.amp.dto;

import lombok.Data;

@Data
public class FacultyDto extends UserDto {
    private Integer id;
    private DepartmentDto departmentDto;
}
