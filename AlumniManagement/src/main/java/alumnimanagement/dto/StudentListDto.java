package alumnimanagement.dto;

import lombok.Data;

@Data
public class StudentListDto {
        private long id;
        private String firstName;
        private String lastName;
        private String email;
        private String state;
        private String city;
}
