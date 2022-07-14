package com.example.almuni.dto;

import com.example.almuni.entity.Address;
import lombok.Data;

@Data
public class JobAdvertisementDto {

    private Long id;
    private String description;
    private String benefits;
    private Address address;
}
