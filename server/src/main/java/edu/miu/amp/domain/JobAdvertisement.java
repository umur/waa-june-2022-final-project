package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor@NoArgsConstructor
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private String benefits;

    @Embedded
    private Address address;

    private String companyName;

    @ManyToMany
    private List<Tag> tags;

    @OneToMany
    private List<JobApplication> jobApplicationList;
}
