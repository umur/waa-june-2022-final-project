package alumnimanagement.repo;

import alumnimanagement.entity.job.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepo extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findTop10ByOrderByPublishDateDesc();
//    findTop10ByOrderByLevelDesc();
//findAllByOrderByIdAsc()
    @Query("SELECT A.state as title, count(S.id) as id FROM Address A JOIN  JobAdvertisement S ON S.address.id = A.id group by A.state")
    List<Object[]> JobByState();
}
