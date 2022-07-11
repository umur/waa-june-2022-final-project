package com.waa.amp.dto;

public record StudentReq(
        String email,
        String firstName,
        String lastname,
        String password,
        String major,
        String gpa
) {}
