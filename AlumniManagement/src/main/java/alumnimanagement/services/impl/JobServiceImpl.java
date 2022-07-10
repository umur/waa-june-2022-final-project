package alumnimanagement.services.impl;

import alumnimanagement.dto.FacultyListDto;
import alumnimanagement.dto.JobAdvertisementDTO;
import alumnimanagement.dto.JobAdvertisementListDTO;
import alumnimanagement.entity.Faculty;
import alumnimanagement.entity.job.JobAdvertisement;
import alumnimanagement.entity.job.Tag;
import alumnimanagement.repo.JobRepo;
import alumnimanagement.services.JobService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    @Override
    public List<JobAdvertisementListDTO> findAllByParam(int page, int size, String searchValue) {
        Pageable pageable = PageRequest.of(page, size);
        List<JobAdvertisement> list = jobRepo.findAll(pageable).stream().toList();
        List<JobAdvertisementListDTO> dtos = new ArrayList<>();
        for(JobAdvertisement f : list)
        {
            JobAdvertisementListDTO dto = new JobAdvertisementListDTO();
            dto.setId(f.getId());
            dto.setState(f.getAddress().getState());

            dto.setJobDesc(f.getJobDesc());
            dto.setJobTitle(f.getJobTitle());
            dto.setCompanyName(f.getCompanyName());
            dto.setJobType(f.getJobType());
            dto.setNumOpening(f.getNumOpening());
//            dto.setAddBenefit(f.getAddBenefit());
//            dto.setCompanySize(f.getCompanySize());
//            dto.setCity(f.getAddress().getCity());
//            dto.setAddBenefit(f.getAddBenefit());
//            dto.setPaymentAmount(f.getPaymentAmount());
            for(Tag t : f.getTags())
            {
               dto.setTag(dto.getTag()+ " " + t.getTitle());
            }
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Long count() {
        Long count = jobRepo.count();
        return count;
    }

    @Override
    public JobAdvertisementDTO findById(int id) {
        return modelMapper.map( jobRepo.findById(id),JobAdvertisementDTO.class);
    }
}
