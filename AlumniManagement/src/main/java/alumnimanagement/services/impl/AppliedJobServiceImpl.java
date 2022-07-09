package alumnimanagement.services.impl;

import alumnimanagement.dto.AppliedJobDTO;
import alumnimanagement.entity.AppliedJob;
import alumnimanagement.repo.AppliedJobRepo;
import alumnimanagement.services.AppliedJobService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AppliedJobServiceImpl implements AppliedJobService {
    private final AppliedJobRepo appliedJobRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(AppliedJobDTO appliedJobDTO) {
        appliedJobRepo.save(modelMapper.map(appliedJobDTO, AppliedJob.class));
    }

    @Override
    public void remove(Long id) {
        appliedJobRepo.deleteById(id);
    }

    @Override
    public List<AppliedJobDTO> findAppliedJobByStudentId(long studentId) {

        return appliedJobRepo.findAllByStudentId(studentId).
                stream().map(appliedJob -> modelMapper.map(appliedJob, AppliedJobDTO.class)).toList();
    }
}
