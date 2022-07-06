package alumnimanagement.dto;

import alumnimanagement.entity.Address;
import lombok.Data;

@Data
public class StudentDTO {

    private String name;
    private Address address;
}
