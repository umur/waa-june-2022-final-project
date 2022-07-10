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
        List<String> jobTag = new ArrayList<>();
        jobTag.add("C#");
        jobTag.add("Java");
        jobTag.add("javaScript");
        jobTag.add("C++");
        jobTag.add("C");
        jobTag.add("MySQL");
        jobTag.add("PostgreSQL");
        jobTag.add("Oracle");
        jobTag.add("Azure");
        jobTag.add("Amazon AWS");
        jobTag.add("Ruby on Rails");
        jobTag.add("SpringBoot");
        jobTag.add("Android");
        jobTag.add("Kotlin");
        jobTag.add("Flutter");
        jobTag.add("Hadoop");
        jobTag.add("Scala");
        jobTag.add(".NET");
        jobTag.add("Python");
        jobTag.add("HTML");
        jobTag.add("CSS");
        jobTag.add("Perl");
        jobTag.add("R");

        for(int i =0 ; i <jobTag.size(); i++)
        {
            TagDTO tagDTO = new TagDTO();
            tagDTO.setId(i);
            tagDTO.setTitle(jobTag.get(i));
            dtos.add(tagDTO);
        }

        return dtos;
    }

}
