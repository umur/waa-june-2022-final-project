package alumnimanagement.repo;

import alumnimanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query("SELECT A.state as title, count(S.id) as id FROM Address A JOIN  Student  S ON S.address.id = A.id group by A.state")
    List<Object[]> StudentByState();
}
