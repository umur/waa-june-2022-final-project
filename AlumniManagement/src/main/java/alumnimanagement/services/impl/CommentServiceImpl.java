package alumnimanagement.services.impl;


import alumnimanagement.dto.CommentDTO;
import alumnimanagement.entity.Comment;
import alumnimanagement.entity.Faculty;
import alumnimanagement.entity.Student;
import alumnimanagement.repo.CommentRepo;
import alumnimanagement.repo.FacultyRepo;
import alumnimanagement.repo.StudentRepo;
import alumnimanagement.services.CommentService;
import alumnimanagement.utility.Helper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final ModelMapper modelMapper;

    private final CommentRepo commentRepo;
    private final StudentRepo studentRepo;

    private final FacultyRepo facultyRepo;

    @Override
    public void create(CommentDTO comment) {
        Comment comment1=modelMapper.map(comment, Comment.class);
        Student stu =studentRepo.findById(comment.getStudentId()).get();
        comment1.setStudent(stu);
        Faculty faculty=facultyRepo.findById(Helper.getLoggedUserId()).get();
        comment1.setFaculty(faculty);

        commentRepo.save(comment1);
    }

    @Override
    public List<CommentDTO> getComment(long id) {
        return commentRepo.findById(id).stream()
                .map(item->modelMapper.map(item,CommentDTO.class))
                .toList();
    }

    @Override
    public void update(CommentDTO commentDTO, long id) {
        commentDTO.setId(id);
        commentRepo.save(modelMapper.map(commentDTO,Comment.class));
    }

    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);
    }


}
