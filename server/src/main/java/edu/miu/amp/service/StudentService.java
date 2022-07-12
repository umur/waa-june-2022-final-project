package edu.miu.amp.service;

import edu.miu.amp.domain.Student;
import edu.miu.amp.dto.JobHistoryDto;
import edu.miu.amp.dto.StudentDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentDto save(StudentDto studentDto);

    List<JobHistoryDto> getStudentJobHistory(Integer id);

    StudentDto getMyProfile();

    List<StudentDto> findAll();

    StudentDto update(StudentDto studentDto, Integer id);

    StudentDto findById(Integer id);


    void remove(Integer id);
}
