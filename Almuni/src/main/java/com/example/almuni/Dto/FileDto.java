package com.example.almuni.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {


    private Long id;
    private String fileName;

    @ManyToMany(mappedBy = "files")
    private List<JobAdvertisementDto> jobAdvertisements;
}
