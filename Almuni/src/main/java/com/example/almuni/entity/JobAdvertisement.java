package com.example.almuni.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String benefits;
    private String companyName;

    @ManyToMany
    private List<File> files;
    @OneToOne
    private Address address;
//    @OneToMany
//    @Embedded
//    private List<Tag> tags;  //todo ???????????????????/

}
