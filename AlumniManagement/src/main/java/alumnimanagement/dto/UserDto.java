package alumnimanagement.dto;

import lombok.Data;

@Data
public class UserDto {

    private String name;
    private  String email;
    private String password1;
    private String password2;
    private String role;
    private boolean agree;


}
