package alumnimanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private double gpa;
    private LocalDateTime lastLoggedInAt;
    private Boolean active;

    @OneToOne
    @JoinColumn(name = "id_major")
    private Department major;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_address")
    private Address address;


}
