package alumnimanagement.entity.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    //todo @OneToOne
    //todo Address address;

    @OneToMany
    private List<Tag> tags;

}
