package alumnimanagement.services;

import alumnimanagement.dto.AppliedJobDTO;
import alumnimanagement.dto.AppliedStudentsDTO;
import alumnimanagement.dto.StudentListDto;

import java.util.List;


public interface AppliedJobService {

    void create(AppliedJobDTO appliedJobDTO);

    void remove(Long id);

    List<AppliedJobDTO> findAppliedJobByStudentId(long studentId);

    List<AppliedStudentsDTO> findStudentsJobAppliedToJob(int id,int page, int size, String searchValue);

    Long countById(int id);
}
