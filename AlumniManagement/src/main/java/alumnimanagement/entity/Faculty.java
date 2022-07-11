package alumnimanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Faculty {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private LocalDateTime lastLoggedInAt;
    private Boolean active;

    private boolean isDeleted;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_address")
    private Address address;


    @OneToMany(mappedBy = "faculty")
    @JsonManagedReference
    private List<Comment> comments;


}
