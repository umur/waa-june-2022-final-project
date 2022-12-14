package alumnimanagement.entity;

import alumnimanagement.entity.helper.JobExperience;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
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

    private String cvLink;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn
    private List<JobExperience> jobExperienceList;

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
