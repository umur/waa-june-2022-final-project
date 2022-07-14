package com.finalproject.Dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CommentsDto implements Serializable {
    private final Long id;
    private final String commenter;
    private final String comment;
    private final LocalDateTime postTime;
}
