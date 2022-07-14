package com.example.alumni.dto.response;


import com.example.alumni.entity.ERole;
import lombok.Data;

@Data
public class RegistrationResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private ERole role;

    private boolean isActive;

    private String userName;

    private String password;

}
