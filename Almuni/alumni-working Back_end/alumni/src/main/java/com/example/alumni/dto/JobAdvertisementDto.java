package com.example.alumni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {


    private Long id;
    private String description;
    private String benefits;

    @ManyToMany //todo ?
    private List<FileDto> files;
    @OneToOne
    private AddressDto address;
//    @OneToMany
//    @Embedded
//    private List<Tag> tags;  //todo ???????????????????/

}
