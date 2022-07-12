package alumnimanagement.services.impl;

import alumnimanagement.dto.JobAdvertisementDTO;
import alumnimanagement.dto.JobAdvertisementListDTO;
import alumnimanagement.dto.ReportList;
import alumnimanagement.entity.job.JobAdvertisement;
import alumnimanagement.entity.job.Tag;
import alumnimanagement.repo.JobRepo;
import alumnimanagement.services.JobService;
import alumnimanagement.utility.Helper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@AllArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepo jobRepo;
    private final ModelMapper modelMapper;


    @Override
    public void create(JobAdvertisementDTO job) {
        var result = modelMapper.map(job, JobAdvertisement.class);
        jobRepo.save(result);
    }

    @Override
    public List<JobAdvertisementDTO> getAll() {
        return jobRepo.findAll()
                .stream().filter(job->!job.isDeleted())
                .map((jobAdvertisement ->
                        modelMapper.map(jobAdvertisement, JobAdvertisementDTO.class)))
                .toList();
    }

    @Override
    public List<String> findAllCompany() {
        return jobRepo.findAllByCompanyNames();
    }

    @Override
    public void update(JobAdvertisementDTO jobAdvertisementDTO, int id) {
        var result = modelMapper.map(jobAdvertisementDTO, JobAdvertisement.class);
        var data = jobRepo.findById(id).get();
        result.setId(id);
        result.setStudent(data.getStudent());
        result.setDeleted(false);
        result.setPublishDate(data.getPublishDate());
        //todo set file location to result from data if not changed from dto
        jobRepo.save(result);
    }

    @Override
    public void delete(int id) {
        jobRepo.findById(id).get().setDeleted(true);
    }

    @Override
    public List<JobAdvertisementDTO> findLastTop10Advertisement() {
        return jobRepo.findTop10ByOrderByPublishDateDesc().stream()
                .map((jobAdvertisement ->
                        modelMapper.map(jobAdvertisement, JobAdvertisementDTO.class)))
                .toList();
    }

    @Override
    public List<JobAdvertisementListDTO> findAllByParam(int page, int size, String state, String city, String tag, String name) {
        if (!state.equals("''") || !city.equals("''") || !tag.equals("''") || !name.equals("''")) {
            return findByFilter(state, city, tag, name).stream().skip(page * size).limit(5).toList();
        }

        Pageable pageable = PageRequest.of(page, size);
        List<JobAdvertisement> list = jobRepo.findAll(pageable).stream().toList();
        List<JobAdvertisementListDTO> dtos = new ArrayList<>();
        for(JobAdvertisement f : list)
        {
            if(!f.isDeleted()) {
                JobAdvertisementListDTO dto = new JobAdvertisementListDTO();
                dto.setId(f.getId());
                if (f.getAddress() != null) {
                    dto.setState(f.getAddress().getState());
                    dto.setCity(f.getAddress().getCity());
                }
                dto.setJobDesc(f.getJobDesc());
                dto.setJobTitle(f.getJobTitle());
                dto.setCompanyName(f.getCompanyName());
                dto.setJobType(f.getJobType());
                dto.setTag(f.getJobTag());
                for (Tag t : f.getTags()) {
                    dto.setTag(dto.getTag() + " " + t.getTitle());
                }
                dtos.add(dto);
            }
        }
        return dtos;
    }

    @Override
    public Long count(String state, String city, String tag, String name) {
        if (!state.equals("''") || !city.equals("''") || !tag.equals("''") || !name.equals("''")) {
            return findByFilter(state, city, tag, name).stream().count();
        }
        Long count = jobRepo.count();
        return count;
    }

    public List<JobAdvertisementListDTO> findByFilter(String state, String city, String tag, String name) {
        List<JobAdvertisement> jobs = jobRepo.findAll().stream().toList();
        List<JobAdvertisementListDTO> jobListDto = new ArrayList<>();
        for (JobAdvertisement job: jobs){
            if(!job.isDeleted()) {
                String jobTag = "";
                if (job.getJobTag() != null) {
                    jobTag = job.getJobTag();
                }
                if (job.getAddress().getState().equals(state) || jobTag.equals(tag) || job.getAddress().getCity().equals(city) || job.getCompanyName().equals(name)) {
                    JobAdvertisementListDTO dto = modelMapper.map(job, JobAdvertisementListDTO.class);
                    dto.setId(job.getId());
                    dto.setState(job.getAddress().getState());
                    dto.setJobDesc(job.getJobDesc());
                    dto.setJobTitle(job.getJobTitle());
                    dto.setCompanyName(job.getCompanyName());
                    dto.setJobType(job.getJobType());
                    dto.setCity(job.getAddress().getCity());
                    if (job.getJobTag() != null) {
                        for (Tag t : job.getTags()) {
                            dto.setTag(dto.getTag() + " " + t.getTitle());
                        }
                    }
                    jobListDto.add(dto);
                }
            }
        }
        return jobListDto;
    }

    @Override
    public JobAdvertisementDTO findById(int id) {
        return modelMapper.map(jobRepo.findById(id), JobAdvertisementDTO.class);
    }

    @Override
    public List<ReportList> JobByState() {
        var result = jobRepo.JobByState();
        List<ReportList> result2 = new ArrayList<>();
        for (Object[] d : result) {
            Long id = (Long) d[1];
            ReportList dto = new ReportList();
            dto.value = id;
            dto.name = (String) d[0];
            result2.add(dto);
        }
        return result2;
    }

    @Override
    public List<JobAdvertisementDTO> findStudentJobList(long id, int page, int size, String searchValue) {

        Pageable pageable = PageRequest.of(page, size);
        return jobRepo.findAllByStudentId(id).stream()
                .map(jobadv -> modelMapper.map(jobadv, JobAdvertisementDTO.class))
                .toList();
    }

    @Override
    public Long countById(long id) {
        Long count = jobRepo.countByStudentId(id);
        return count;
    }

    @Override
    public List<ReportList> findByTags() {
        var data = jobRepo.findByTags();
        Map<String, Integer> map = new HashMap<>();
        for (String s : data) {
            String[] splitArr = s.split(",");
            for (String str : splitArr) {
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
        }
        return getReportLists(map);
    }

    private List<ReportList> getReportLists(Map<String, Integer> map) {
        List<ReportList> result2 = new ArrayList<>();
        for (Map.Entry<String, Integer> set :
                map.entrySet()) {
            ReportList dto = new ReportList();
            dto.value = (long) set.getValue();
            dto.name = set.getKey();
            result2.add(dto);

        }
        return result2;
    }

    @Override
    public  List<ReportList> jobsByStateTag(String state) {
        var result = jobRepo.findJobAdvertisementsByAddressStateContaining(state);
        Map<String, Integer> map = new HashMap<>();
        for (JobAdvertisement j: result){
            var data = j.getJobTag();
            if (data == null) continue;
            String[] splitArr = data.split(",");
            for (String str : splitArr) {
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
        }

        return getReportLists(map);
    }
}
