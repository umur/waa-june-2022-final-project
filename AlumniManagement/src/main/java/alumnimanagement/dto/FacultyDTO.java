package alumnimanagement.dto;

import alumnimanagement.entity.Address;
import lombok.Data;

@Data
public class FacultyDTO {
    private String firstName;
    private String lastName;
    private String email;
    private AddressDTO address;
}
