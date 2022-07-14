package com.example.alumni.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "jobAdvertisements")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String benefits;
    private String companyName;

    private LocalDate postedDate;

    private boolean isApplied;

    private LocalDate appliedDate;
    @ManyToMany
    private List<File> files;
    @OneToOne
    private Address address;

    public JobAdvertisement(Long id, String description, String benefits,
                            String companyName, List<File> files, Address address) {
        this.id = id;
        this.description = description;
        this.benefits = benefits;
        this.companyName = companyName;
        this.files = files;
        this.address = address;
    }

    //    @OneToMany
//    @Embedded
//    private List<Tag> tags;  //todo ???????????????????/

}
