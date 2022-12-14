package alumnimanagement.repo;

import alumnimanagement.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long> {
   @Query("SELECT F.department as departmentName,count(F.department) as count from Faculty F group by F.department")
    List<Object[]> facultyByDepartment();


}
