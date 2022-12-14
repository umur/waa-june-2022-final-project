package alumnimanagement.repo;
import alumnimanagement.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {


    @Query("select c from Comment c where c.student.id=:stId")
    List<Comment> commentByStudentId(@Param("stId") long id);

    @Query("select count(c) from Comment c where c.student.id=:id")
    long countById(@Param("id") long id);

}
