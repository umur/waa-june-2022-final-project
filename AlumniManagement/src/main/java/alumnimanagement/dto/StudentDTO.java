package alumnimanagement.dto;

import alumnimanagement.entity.Address;
import lombok.Data;

@Data
public class StudentDTO {
    private String firstName;
    private String lastName;
    private String email;
    private AddressDTO address;
}
