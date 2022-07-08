package alumnimanagement.entity;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;
    private String createdBy;
    private String updatedBy;
    private boolean isActive;
    private boolean isDeleted;

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Student student;




}
