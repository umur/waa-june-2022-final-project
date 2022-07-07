package alumnimanagement.repo;
import alumnimanagement.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CommentRepo extends JpaRepository<Comment, Long> {
}
