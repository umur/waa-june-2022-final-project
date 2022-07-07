package alumnimanagement.repo;

import alumnimanagement.entity.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvRepo extends JpaRepository<Cv, Long> {
}
