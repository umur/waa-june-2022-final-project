package alumnimanagement.repo;

import alumnimanagement.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo extends JpaRepository<Education, Long> {
}
