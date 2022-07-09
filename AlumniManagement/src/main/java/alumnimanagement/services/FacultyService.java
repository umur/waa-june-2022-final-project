package alumnimanagement.services;

import alumnimanagement.dto.FacultyDTO;
import alumnimanagement.dto.FacultyListDto;
import alumnimanagement.dto.StudentListDto;

import java.util.List;

public interface FacultyService {
    void create(FacultyDTO facultyDTO);

    void update(long id, FacultyDTO facultyDTO) throws Exception;

    List<FacultyDTO> findAll();

    void remove(long id);

    List<FacultyListDto> findAllByParam(int page, int size, String searchValue);
    Long count();
}
