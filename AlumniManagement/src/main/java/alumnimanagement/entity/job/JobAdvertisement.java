package alumnimanagement.entity.job;

import alumnimanagement.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
    @Id
    private int id;
    private String title;
    private String description;
    private String benefits;
    private String companyName;
    private LocalDateTime publishDate;

    //todo @OneToOne
    //todo Address address;
    @OneToOne
    @JoinColumn(name="id_address")
    private Address address;

    @OneToMany
    private List<Tag> tags;

}
