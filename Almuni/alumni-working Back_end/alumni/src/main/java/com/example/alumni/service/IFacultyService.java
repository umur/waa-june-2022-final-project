package com.example.alumni.service;



import com.example.alumni.dto.FacultyDto;
import com.example.alumni.entity.Faculty;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFacultyService {

    ResponseEntity<FacultyDto> addFaculty(Faculty faculty);
    ResponseEntity<List<FacultyDto>> getAllFaculty();


    ResponseEntity<FacultyDto> getFacultyById(Long id);

    String deleteById(Long id);
    ResponseEntity<FacultyDto> updateFaculty(Faculty faculty,Long id);
    //ResponseEntity<FacultyDto> resetPassword(FacultyDto facultyDto);
    Faculty findByEmail(String email);

}
