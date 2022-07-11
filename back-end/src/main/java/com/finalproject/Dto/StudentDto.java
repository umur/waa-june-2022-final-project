package com.finalproject.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StudentDto implements Serializable {
    private final Long id;
    private final Integer studentId;
    private final String firstName;
    private final String lastName;
    private final Double gpa;
    private final String major;
    private final UserDto user;
    private final List<CommentsDto> comments;
}
