package alumnimanagement.dto;

import alumnimanagement.entity.Address;
import lombok.Data;

@Data
public class FacultyDTO {
    private String name;
    private Address address;
}
