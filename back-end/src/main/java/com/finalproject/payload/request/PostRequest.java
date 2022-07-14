package com.finalproject.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostRequest {
    @NotBlank
    @Size(max=400)
    private String comment;
    private String commenter;
}
