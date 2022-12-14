package alumnimanagement.entity.authUser;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "STUDENT")
public class StudentRole extends UserAuth{
}
