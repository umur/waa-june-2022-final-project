package alumnimanagement.entity.authUser;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FACULTY")
public class FacultyRole extends UserAuth{
}
