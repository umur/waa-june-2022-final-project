package alumnimanagement.controller;

import alumnimanagement.dto.CommentDTO;
import alumnimanagement.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
@CrossOrigin
public class CommentController {


    private final CommentService commentService;

    @PostMapping()
    public void writeComment(@RequestBody  CommentDTO commentDTO){

        commentService.create(commentDTO);
    }

    @GetMapping("/{id}")
    public List<CommentDTO> getComment(@PathVariable long id){
       return commentService.getComment(id);
    }

    @PutMapping
    public void updateComment(CommentDTO commentDTO, long id){
        commentService.update(commentDTO,id);
    }

    @DeleteMapping
    public void deleteComment(long id){
        commentService.delete(id);
    }
}
