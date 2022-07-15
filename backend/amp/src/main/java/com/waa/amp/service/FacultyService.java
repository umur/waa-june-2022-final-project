package com.waa.amp.service;

import com.waa.amp.entity.Faculty;
import com.waa.amp.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public List<Faculty> allFaculty() {
        return facultyRepository.findAll();
    }



}
