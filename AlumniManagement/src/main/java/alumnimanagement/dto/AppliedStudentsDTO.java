package alumnimanagement.dto;

import alumnimanagement.entity.Department;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppliedStudentsDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Department major;
    private double gpa;
    private LocalDateTime lastLoggedInAt;
    private Boolean active;
    private AddressDTO address;
    private String cvLink;
}
