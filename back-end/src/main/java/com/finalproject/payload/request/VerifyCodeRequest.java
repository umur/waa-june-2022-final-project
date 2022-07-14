package com.finalproject.payload.request;

import lombok.Data;

@Data
public class VerifyCodeRequest {
    private String username;
    private String code;
    private String password;
}
