package com.finalproject.service.impl;

import com.finalproject.models.Tags;
import com.finalproject.repository.TagsRepo;
import com.finalproject.service.TagSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagSevice {

    @Autowired
    private TagsRepo tagsRepo;

    @Override
    public List<Tags> findAll() {
        List<Tags> tags = new ArrayList<>();
        tagsRepo.findAll().forEach(tag-> {
            tags.add(tag);
        });
        return tags;
    }
}
