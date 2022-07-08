package edu.miu.amp.dto;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class AddressDto {
    private String city;
    private String state;
    private String zip;
}
