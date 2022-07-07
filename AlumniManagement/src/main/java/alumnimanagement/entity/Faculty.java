package alumnimanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Faculty {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_address")
    private Address address;


}
