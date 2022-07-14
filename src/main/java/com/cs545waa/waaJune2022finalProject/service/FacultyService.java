package com.cs545waa.waaJune2022finalProject.service;

import com.cs545waa.waaJune2022finalProject.dto.FacultyDto;
import com.cs545waa.waaJune2022finalProject.dto.StudentDto;

public interface FacultyService {
    void registerFaculty(FacultyDto faculty);

    void editProfile(FacultyDto facultyDto, int id);

    FacultyDto getFacultyByUsername(String username);
}
