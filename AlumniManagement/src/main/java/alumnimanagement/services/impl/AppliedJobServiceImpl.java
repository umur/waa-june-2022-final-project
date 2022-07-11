package alumnimanagement.services.impl;

import alumnimanagement.dto.AppliedJobDTO;
import alumnimanagement.entity.AppliedJob;
import alumnimanagement.entity.Student;
import alumnimanagement.entity.job.JobAdvertisement;
import alumnimanagement.repo.AppliedJobRepo;
import alumnimanagement.repo.JobRepo;
import alumnimanagement.repo.StudentRepo;
import alumnimanagement.services.AppliedJobService;
import alumnimanagement.utility.Helper;
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

    private StudentRepo studentRepo;

    private JobRepo jobRepo;


    @Override
    public void create(AppliedJobDTO appliedJobDTO) {
        Student student = studentRepo.findById(appliedJobDTO.getId_student()).get();
        JobAdvertisement jobAdvertisement = jobRepo.findById(appliedJobDTO.getId_job()).get();

//        AppliedJob appliedJob = modelMapper.map(appliedJobDTO, AppliedJob.class);
        AppliedJob appliedJob = new AppliedJob();
        appliedJob.setAppliedDate(Helper.getCurrentDate());
        appliedJob.setStudent(student);
        appliedJob.setAdditionalComment(appliedJobDTO.getAdditionalComment());
        appliedJob.setIsActive(appliedJobDTO.getIsActive());
        appliedJob.setIsDeleted(appliedJobDTO.getIsDeleted());
        appliedJob.setJobAdvertisement(jobAdvertisement);
        appliedJobRepo.save(appliedJob);
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
