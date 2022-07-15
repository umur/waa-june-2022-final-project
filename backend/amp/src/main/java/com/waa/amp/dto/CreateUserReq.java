package com.waa.amp.dto;

import com.waa.amp.entity.UserType;

public record CreateUserReq(String username,
                            String password,
                            UserType userType,
                            String firstname,
                            String lastname,
                            String city) {
}
