package alumnimanagement.services.impl;

import alumnimanagement.dto.JobAdvertisementDTO;
import alumnimanagement.entity.job.JobAdvertisement;
import alumnimanagement.repo.JobRepo;
import alumnimanagement.services.JobService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepo jobRepo;
    private final ModelMapper modelMapper;


    @Override
    public void create(JobAdvertisementDTO job) {
        jobRepo.save(modelMapper.map(job, JobAdvertisement.class));
    }

    @Override
    public List<JobAdvertisementDTO> getAll() {
        return jobRepo.findAll()
                .stream()
                .map((jobAdvertisement ->
                        modelMapper.map(jobAdvertisement, JobAdvertisementDTO.class)))
                .toList();
    }

    @Override
    public void update(JobAdvertisementDTO jobAdvertisementDTO, int id) {
        jobAdvertisementDTO.setId(id);
        jobRepo.save(modelMapper.map(jobAdvertisementDTO, JobAdvertisement.class));
    }

    @Override
    public void delete(int id) {
        jobRepo.deleteById(id);
    }

    @Override
    public List<JobAdvertisementDTO> findLastTop10Advertisement() {
        return jobRepo.findTop10ByOrderByPublishDateDesc().stream()
                .map((jobAdvertisement ->
                        modelMapper.map(jobAdvertisement, JobAdvertisementDTO.class)))
                .toList();
    }
}
