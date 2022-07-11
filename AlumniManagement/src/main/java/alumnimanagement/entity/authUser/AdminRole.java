package alumnimanagement.entity.authUser;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ADMIN")
public class AdminRole extends UserAuth {
}
