package alumnimanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Faculty {
    @Id
    private long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;


}
