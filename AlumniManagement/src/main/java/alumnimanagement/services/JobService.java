package alumnimanagement.services;

import alumnimanagement.dto.JobAdvertisementDTO;

import java.util.List;

public interface JobService {

    void create(JobAdvertisementDTO job);

    List<JobAdvertisementDTO> getAll();

    void update(JobAdvertisementDTO jobAdvertisementDTO, int id);

    void delete(int id);

    List<JobAdvertisementDTO> findLastTop10Advertisement();
}
