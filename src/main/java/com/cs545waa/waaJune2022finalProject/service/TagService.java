package com.cs545waa.waaJune2022finalProject.service;

import com.cs545waa.waaJune2022finalProject.dto.TagDTO;
import com.cs545waa.waaJune2022finalProject.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<TagDTO> getAll();

   Optional<Tag>  getById(int id);

}


