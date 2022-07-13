package com.waa.amp.dto;

import com.waa.amp.entity.UserType;

public record StudentReq(
        String email,
        String firstName,
        String lastname,
        String major,
        String gpa,
        String city,
        UserType userType

) {}
