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

    @ManyToMany //todo ?
    private List<File> files;
//    @OneToMany
//    @Embedded
//    private List<Tag> tags;  //todo ???????????????????/

}
