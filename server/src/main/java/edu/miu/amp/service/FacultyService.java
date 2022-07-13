package edu.miu.amp.service;

import edu.miu.amp.dto.FacultyDto;
import edu.miu.amp.dto.StudentDto;

import java.util.List;

public interface FacultyService {
    FacultyDto getMyProfile();
    List<FacultyDto> findAll();

    FacultyDto save(FacultyDto facultyDto);

    FacultyDto findById(Integer id);

    void remove(Integer id);

    FacultyDto updateById(FacultyDto facultyDto, Integer id);
}
