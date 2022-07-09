package alumnimanagement.services;

import alumnimanagement.dto.AppliedJobDTO;

import java.util.List;


public interface AppliedJobService {

    void create(AppliedJobDTO appliedJobDTO);

    void remove(Long id);

    List<AppliedJobDTO> findAppliedJobByStudentId(long studentId);
}
