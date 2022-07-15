package com.waa.amp.dto;

import java.util.List;

public record JobReq(String description,
                     List<String> tag,
                     String state,
                     String city,
                     String companyName) {
}
