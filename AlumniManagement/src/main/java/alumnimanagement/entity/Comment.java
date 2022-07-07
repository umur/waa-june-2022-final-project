package alumnimanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    private long id;
    private String comment;


}
