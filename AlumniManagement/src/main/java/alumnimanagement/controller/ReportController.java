package alumnimanagement.controller;

import alumnimanagement.dto.DropdownDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reports")
@AllArgsConstructor
@CrossOrigin
public class ReportController {

    @GetMapping("/state")
    public List<DropdownDto> state() {
        List<DropdownDto> list = new ArrayList<>();
        for(int i =1 ; i <20; i++)
        {
            DropdownDto dto = new DropdownDto();
            dto.setId(i);
            dto.setTitle("State" +i);
            list.add(dto);
        }
        return list;
    }

    @GetMapping("/city")
    public List<DropdownDto> city() {
        List<DropdownDto> list = new ArrayList<>();
        for(int i =1 ; i <20; i++)
        {
            DropdownDto dto = new DropdownDto();
            dto.setId(i);
            dto.setTitle("City" +i);
            list.add(dto);
        }
        return list;
    }

    @GetMapping("/major")
    public List<DropdownDto> major() {
        List<DropdownDto> list = new ArrayList<>();
        for(int i =1 ; i <20; i++)
        {
            DropdownDto dto = new DropdownDto();
            dto.setId(i);
            dto.setTitle("Major" +i);
            list.add(dto);
        }
        return list;
    }

    @GetMapping("/studentName")
    public List<DropdownDto> studentName() {
        List<DropdownDto> list = new ArrayList<>();
        for(int i =1 ; i <20; i++)
        {
            DropdownDto dto = new DropdownDto();
            dto.setId(i);
            dto.setTitle("Name" +i);
            list.add(dto);
        }
        return list;
    }
}
