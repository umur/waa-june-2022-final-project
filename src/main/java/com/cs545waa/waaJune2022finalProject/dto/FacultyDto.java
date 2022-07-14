package com.cs545waa.waaJune2022finalProject.dto;

import com.cs545waa.waaJune2022finalProject.entity.Department;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FacultyDto {

    private int id;


    private String firstName;

    private String lastName;

    private String email;

    private DepartmentDTO department;

    @JsonManagedReference(value = "faculty")
    private AddressDto address;


//    private LocalDateTime LastLoggedInAt;

//    private boolean active;

    //Faculty can write comments on students.
    //  Only faculty can see the comments.
//    @OneToMany
//    private List<CommentDto> facultyFeedbacks;
}
