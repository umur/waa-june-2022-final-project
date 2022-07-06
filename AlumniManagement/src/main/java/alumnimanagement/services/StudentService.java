package alumnimanagement.services;

import alumnimanagement.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    void create(StudentDTO studentDTO);

    void update(long id, StudentDTO studentDTO) throws Exception;

    List<StudentDTO> findAll();

    void remove(long id);
}
