package alumnimanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;
//    private long createdBy;
//    private long updatedBy;
    private boolean isActive;
    private boolean isDeleted;

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Student student;




}
