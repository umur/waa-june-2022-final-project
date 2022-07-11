package com.finalproject.Dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserDto implements Serializable {
    private final Long id;
    @NotBlank
    @Size(max = 20)
    private final String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private final String email;
    @NotBlank
    @Size(max = 120)
    private final String password;
    private final boolean isActive;
    private final String firstName;
    private final String lastName;
    private final boolean soft_deleted;
    private final LocalDateTime last_logged;
}
