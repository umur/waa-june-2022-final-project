package edu.miu.amp.dto;

import edu.miu.amp.domain.Address;
import lombok.Data;

import javax.persistence.Embedded;
@Data
public class UserDto{
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    @Embedded
    private Address address;
    private Boolean active;
}
