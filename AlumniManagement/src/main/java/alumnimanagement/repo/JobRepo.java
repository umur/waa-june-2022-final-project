package alumnimanagement.repo;

import alumnimanagement.entity.job.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepo extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findTop10ByOrderByPublishDateDesc();
//    findTop10ByOrderByLevelDesc();
//findAllByOrderByIdAsc()
}
