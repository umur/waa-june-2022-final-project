package com.waa.amp.dto;

public record JobSearchReq(String tags,
                           String state,
                           String city,
                           String companyName) {
}
