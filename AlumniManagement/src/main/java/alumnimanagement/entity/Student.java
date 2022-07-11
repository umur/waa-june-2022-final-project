package alumnimanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private double gpa;
    private Boolean active;
    private long userId;
    private boolean isDeleted;

    @OneToOne
    @JoinColumn(name = "id_major")
    private Department major;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_address")
    private Address address;

//    @OneToMany
//    @JsonManagedReference
//    private List<Comment> comment;


}
