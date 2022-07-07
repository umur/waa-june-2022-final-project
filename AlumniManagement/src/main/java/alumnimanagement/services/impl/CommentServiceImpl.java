package alumnimanagement.services.impl;


import alumnimanagement.dto.CommentDTO;
import alumnimanagement.entity.Comment;
import alumnimanagement.repo.CommentRepo;
import alumnimanagement.services.CommentService;
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

    @Override
    public void create(CommentDTO comment) {
        commentRepo.save(modelMapper.map(comment, Comment.class));}

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
