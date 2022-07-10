package alumnimanagement.services;

import alumnimanagement.dto.*;

import java.util.List;

public interface StudentService {
    void create(StudentDTO studentDTO);

    void update(long id, StudentDTO studentDTO) throws Exception;

    List<StudentDTO> findAll();

    void remove(long id);
    List<StudentListDto> findAllByParam(int page, int size, String state, String city, String major, String studentName);
    Long totalStudents(String state, String city, String major, String studentName);

    StudentDTO findStudentById(long id);

    List<ReportList> StudentByState();

    void updateStudentCV(long id, UpdateCVDTO updateCVDTO);
}
