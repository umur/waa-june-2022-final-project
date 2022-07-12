package com.cs545waa.waaJune2022finalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URI;
import java.net.URL;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    // cloud url of the file
    private String url;
    @ManyToOne
    private JobAdvertisement jobAdvertisement;
}
