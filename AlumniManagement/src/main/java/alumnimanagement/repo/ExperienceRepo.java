package alumnimanagement.repo;

import alumnimanagement.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepo extends JpaRepository<Experience,Long> {
}
