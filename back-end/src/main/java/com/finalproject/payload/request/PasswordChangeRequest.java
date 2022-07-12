package com.finalproject.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PasswordChangeRequest {
//    @NotBlank
//    @Size(max=24)
    private String password;

    public PasswordChangeRequest() {

    }
}
