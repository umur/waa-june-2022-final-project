package alumnimanagement.controller;

import alumnimanagement.dto.CvDto;
import alumnimanagement.services.CvService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cvs")
@AllArgsConstructor
public class CvController {


    private final CvService cvService;

    @GetMapping
    public List<CvDto> findAll(){
        return cvService.getAll();
    }
}
