package alumnimanagement.dto;

import alumnimanagement.entity.Address;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FacultyDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private LocalDateTime lastLoggedInAt;
    private Boolean active;
    private AddressDTO address;
}
