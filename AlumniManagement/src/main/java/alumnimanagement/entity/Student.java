package alumnimanagement.entity;

import lombok.Data;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "id_major")
    private Department major;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_address")
    private Address address;


}
