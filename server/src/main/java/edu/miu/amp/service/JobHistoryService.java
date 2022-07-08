package edu.miu.amp.service;

import edu.miu.amp.domain.JobHistory;
import edu.miu.amp.dto.JobHistoryDto;

import java.util.List;

public interface JobHistoryService {

    List<JobHistoryDto> getAllJobHistory();

    JobHistoryDto getJobHistory(Integer id);

    JobHistoryDto addJobHistory(JobHistoryDto data);

    JobHistoryDto updateJobHistory(Integer id, JobHistoryDto data);

    void deleteJobHistory(Integer id);

}
