package edu.miu.amp.service;

import edu.miu.amp.dto.JobHistoryDto;
import edu.miu.amp.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto save(StudentDto studentDto);

    List<JobHistoryDto> getStudentJobHistory(Integer id);

    StudentDto getMyProfile();

    List<StudentDto> findAll();

    StudentDto update(StudentDto studentDto, Integer id);

    StudentDto findById(Integer id);

    void remove(Integer id);
}
