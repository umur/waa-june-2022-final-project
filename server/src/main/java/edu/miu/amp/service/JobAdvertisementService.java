package edu.miu.amp.service;

import edu.miu.amp.dto.JobAdvertisementDto;
import edu.miu.amp.repository.JobAdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface JobAdvertisementService {
    List<JobAdvertisementDto> findAll();

    JobAdvertisementDto save(JobAdvertisementDto jobAdvertisementDto);

    JobAdvertisementDto findById(Integer id);

    void remove(Integer id);

    JobAdvertisementDto updateById(JobAdvertisementDto jobAdvertisementDto, Integer id);

    List<JobAdvertisementDto> findFirst10Advertisement();
}
