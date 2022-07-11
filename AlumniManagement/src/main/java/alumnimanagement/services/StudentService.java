package alumnimanagement.services;

import alumnimanagement.dto.DropdownDto;
import alumnimanagement.dto.ReportList;
import alumnimanagement.dto.StudentDTO;
import alumnimanagement.dto.StudentListDto;

import java.util.List;

public interface StudentService {
    void create(StudentDTO studentDTO);

    void update(long id, StudentDTO studentDTO) throws Exception;

    List<StudentDTO> findAll();

    void remove(long id);
    List<StudentListDto> findAllByParam(int page, int size, String state, String city, String major, String studentName,long id);
    Long totalStudents(String state, String city, String major, String studentName,long id);

    StudentDTO findStudentById(long id);

    List<ReportList> StudentByState();

    List<Object[]> findByStateCity(String state);

}
