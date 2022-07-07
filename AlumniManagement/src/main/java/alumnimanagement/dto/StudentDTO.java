package alumnimanagement.dto;

import alumnimanagement.entity.Address;
import alumnimanagement.entity.Department;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Department major;
    private double gpa;
    private LocalDateTime lastLoggedInAt;
    private Boolean active;
    private AddressDTO address;
}
