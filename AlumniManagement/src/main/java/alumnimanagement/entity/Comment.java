package alumnimanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private Faculty faculty;


    @ManyToOne
//    @JsonBackReference
    private Student student;




}
