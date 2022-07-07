package edu.miu.amp.service.impl;

import edu.miu.amp.domain.JobHistory;
import edu.miu.amp.dto.JobHistoryDto;

import edu.miu.amp.exception.ResourceNotFoundException;
import edu.miu.amp.repository.JobHistoryRepo;
import edu.miu.amp.service.JobHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {

    @Autowired
    private JobHistoryRepo jobHistoryRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<JobHistoryDto> getAllJobHistory() {
        var jobHistoryList = jobHistoryRepo.findAll();
        var resList = jobHistoryList.stream().map(jobHistory -> modelMapper.map(jobHistory, JobHistoryDto.class)).collect(Collectors.toList());
        return resList;
    }

    @Override
    public JobHistoryDto getJobHistory(Integer id) {
        var jobHistory = jobHistoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("JobHistory", "id", id));
        ;
        return modelMapper.map(jobHistory, JobHistoryDto.class);
    }

    @Override
    public JobHistoryDto addJobHistory(JobHistoryDto data) {
        var jobHistory = modelMapper.map(data, JobHistory.class);
        var jobHistorySaved = jobHistoryRepo.save(jobHistory);
        return modelMapper.map(jobHistorySaved, JobHistoryDto.class);
    }

    @Override
    public JobHistoryDto updateJobHistory(Integer id, JobHistoryDto data) {
        var existingJobHistory = jobHistoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("JobHistory", "id", id));

        existingJobHistory.setCompanyName(data.getCompanyName());
        existingJobHistory.setStartDate(data.getStartDate());
        existingJobHistory.setEndDate(data.getEndDate());
        existingJobHistory.setReasonToLeave(data.getReasonToLeave());
        existingJobHistory.setComment(data.getComment());

        var updatedJobHistory = jobHistoryRepo.save(existingJobHistory);

        return modelMapper.map(updatedJobHistory, JobHistoryDto.class);

    }

    @Override
    public void deleteJobHistory(Integer id) {
        jobHistoryRepo.deleteById(id);
    }
}
