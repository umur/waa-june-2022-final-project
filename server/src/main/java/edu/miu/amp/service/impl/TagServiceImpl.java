package edu.miu.amp.service.impl;

import edu.miu.amp.domain.Tag;
import edu.miu.amp.dto.TagDto;
import edu.miu.amp.repository.TagRepository;
import edu.miu.amp.service.TagService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TagDto> findAll() {
        List<Tag> tags = tagRepository.findAll();
        List<TagDto> tagDtos = tags.stream()
                .map(tag -> toDto(tag))
                .collect(Collectors.toList());
        return tagDtos;
    }


    @Override
    public TagDto save(TagDto tagDto) {
        Tag tag = toEntity(tagDto);
        return toDto(tagRepository.save(tag));
    }

    @Override
    public TagDto findById(Integer id) {
        var tag = tagRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Tag with id %s does not exists", id)));
        TagDto tagDto = toDto(tag);
        return tagDto;
    }

    @Override
    public void remove(Integer id) {
        tagRepository.deleteById(id);

    }

    @Override
    public TagDto updateById(TagDto tagDto, Integer id) {
        Tag tag = toEntity(tagDto);
        tagRepository.findById(id).map(tag1 -> {
            tag1.setId(tag.getId());
            tag1.setTagName(tag.getTagName());
            tag1.setJobAdvertisementList(tag.getJobAdvertisementList());
            return tagRepository.save(tag);
        });
        return toDto(tag);
    }

    @Override
    public List<TagDto> searchTagsBy(String name){
        List<Tag> tags = tagRepository.searchTagsBy(name);
        List<TagDto> tagsDto = tags.stream()
                .map(t -> toDto(t))
                .collect(Collectors.toList());
        return tagsDto;
    }

    public TagDto toDto(Tag tag) {
        TagDto tagDto = modelMapper.map(tag, TagDto.class);
        return tagDto;
    }

    public Tag toEntity(TagDto tagDto) {
        Tag tag = modelMapper.map(tagDto, Tag.class);
        return tag;
    }

}
