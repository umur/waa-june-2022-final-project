package alumnimanagement.repo;


import alumnimanagement.entity.AppliedJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppliedJobRepo extends JpaRepository<AppliedJob, Long> {
//    @Query("Select * from ")
    List<AppliedJob> findAllByStudentId(Long id);
    List<AppliedJob> findAllByJobAdvertisementId(int jobId);
}
