package com.waa.amp.dto;

public record StudentSearchReq(String state,
                               String city,
                               String major,
                               String firstname,
                               String lastname) {
}
