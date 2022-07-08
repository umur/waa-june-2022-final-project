package edu.miu.amp.service;

import edu.miu.amp.dto.FacultyDto;

import java.util.List;

public interface FacultyService {
    List<FacultyDto> findAll();

    FacultyDto save(FacultyDto facultyDto);

    FacultyDto findById(Integer id);

    void remove(Integer id);

    FacultyDto updateById(FacultyDto facultyDto, Integer id);
}
