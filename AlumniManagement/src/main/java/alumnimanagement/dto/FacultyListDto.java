package alumnimanagement.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FacultyListDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String state;
    private String city;
}
