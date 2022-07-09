package alumnimanagement.entity.job;

import alumnimanagement.entity.Student;
import alumnimanagement.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String jobTitle;
    private String jobDesc;
    private String addBenefit;
    private String companyName;
    private LocalDateTime publishDate;
    private String companySize;
    private int numOpening;
    private String jobType;
    private float paymentAmount;


    //todo @OneToOne
    //todo Address address;
    @OneToOne
    @JoinColumn(name="id_address")
    private Address address;

    @OneToMany
    @JoinColumn(name = "id_jobadvertisement")
    private List<Tag> tags;

    @ManyToOne
    Student student;

}
