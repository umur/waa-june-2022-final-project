package alumnimanagement.services;

import alumnimanagement.dto.StudentDTO;
import alumnimanagement.dto.StudentListDto;

import java.util.List;

public interface StudentService {
    void create(StudentDTO studentDTO);

    void update(long id, StudentDTO studentDTO) throws Exception;

    List<StudentDTO> findAll();

    void remove(long id);
    List<StudentListDto> findAllByParam(int page, int size, String searchValue);
    Long totalStudents();

    StudentDTO findStudentById(long id);
}
