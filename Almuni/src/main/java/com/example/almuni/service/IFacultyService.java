package com.example.almuni.service;

import com.example.almuni.Dto.FacultyDto;
import com.example.almuni.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFacultyService {

    ResponseEntity<FacultyDto> addFaculty(FacultyDto facultyDto);
    ResponseEntity<List<FacultyDto>> getAllFaculty();


    ResponseEntity<FacultyDto> getFacultyById(Long id);

    String deleteById(Long id);
    ResponseEntity<FacultyDto> updateFaculty(FacultyDto facultyDto,Long id);
    //ResponseEntity<FacultyDto> resetPassword(FacultyDto facultyDto);



}
