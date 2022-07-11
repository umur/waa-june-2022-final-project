package edu.miu.amp.controller;

import edu.miu.amp.dto.TagDto;
import edu.miu.amp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/v1/api/tags")
@CrossOrigin
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    @RolesAllowed("student")
    public ResponseEntity<List<TagDto>> findAll(){
        return new ResponseEntity<>(tagService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @RolesAllowed("student")
    public ResponseEntity<TagDto> getById(@PathVariable Integer id){
        return new ResponseEntity<>(tagService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @RolesAllowed("student")
    public ResponseEntity<TagDto> create(@RequestBody TagDto tagDto){
        return new ResponseEntity<> (tagService.save(tagDto), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    @RolesAllowed("student")
    public ResponseEntity<TagDto> update(@RequestBody TagDto tagDto, @PathVariable Integer id){
        tagDto.setId(id);
        return new ResponseEntity<>(tagService.save(tagDto), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @RolesAllowed("student")
    public void delete(@PathVariable Integer id){
        tagService.remove(id);
    }

    @GetMapping("/search")
    @RolesAllowed("student")
    public ResponseEntity<List<TagDto>> searchTagsBy(@RequestParam("query") String query){
        return new ResponseEntity<> (tagService.searchTagsBy(query), HttpStatus.OK);
    }
}
