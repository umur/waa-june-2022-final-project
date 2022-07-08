package alumnimanagement.controller;

import alumnimanagement.dto.StudentDTO;
import alumnimanagement.dto.TagDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tags")
@CrossOrigin
public class TagController {

    @GetMapping
    public List<TagDTO> findAllStudent() {
        List<TagDTO> dtos = new ArrayList<>();
        for(int i =1 ; i <20; i++)
        {
            TagDTO tagDTO = new TagDTO();
            tagDTO.setId(i);
            tagDTO.setTitle("Title is " +i);
            dtos.add(tagDTO);
        }

        return dtos;
    }

}
