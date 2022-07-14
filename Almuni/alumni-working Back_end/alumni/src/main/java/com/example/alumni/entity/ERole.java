package com.example.alumni.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ERole {

    ROLE_ADMIN,
    ROLE_FACULTY,
    ROLE_STUDENT;

//    @JsonCreator
//    public static ERole create(String value) {
//        return ERole.valueOf(value.toUpperCase());
//    }
}
