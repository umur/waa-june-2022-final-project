package alumnimanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private  String name;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

//    Todo
//  @OneToMany(mappedBy = "id_student")
//    private List<Comment> comment;
}
