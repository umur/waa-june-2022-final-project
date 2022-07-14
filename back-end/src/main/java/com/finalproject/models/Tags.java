package com.finalproject.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
