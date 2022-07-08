package alumnimanagement.dto;

import lombok.Data;

@Data
public class CommentDTO {

    private long id;
    private String comment;
    private long studentId;
}
