package alumnimanagement.services;

import alumnimanagement.dto.CommentDTO;
import alumnimanagement.entity.Comment;

import java.util.List;

public interface CommentService {

    void create(CommentDTO comment);

    List<CommentDTO> getComment(long id);

    void update(CommentDTO commentDTO, long id);

    void delete(long id);

    List<CommentDTO> commentByStudentId(long id);

    Long count(long id);
}
