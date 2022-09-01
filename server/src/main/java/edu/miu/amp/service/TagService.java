package edu.miu.amp.service;

import edu.miu.amp.dto.TagDto;

import java.util.List;

public interface TagService {
    List<TagDto> findAll();

    TagDto save(TagDto tagDto);

    TagDto findById(Integer id);

    void remove(Integer id);

    List<TagDto> searchTagsBy(String name);

    TagDto updateById(TagDto tagDto, Integer id);
}
