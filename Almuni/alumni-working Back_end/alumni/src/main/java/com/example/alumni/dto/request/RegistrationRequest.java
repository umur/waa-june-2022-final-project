package com.example.alumni.dto.request;

import com.example.alumni.entity.ERole;
import lombok.Data;

@Data
public class RegistrationRequest {

    private String firstName;

    private String lastName;

    private String role;

    private String email;

    private String userName;

    private String password;
}
