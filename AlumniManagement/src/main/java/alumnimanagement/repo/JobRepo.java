package alumnimanagement.repo;

import alumnimanagement.entity.job.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<JobAdvertisement, Integer> {
}
