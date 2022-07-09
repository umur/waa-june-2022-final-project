package alumnimanagement.controller;

import alumnimanagement.dto.JobAdvertisementDTO;
import alumnimanagement.services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/getAll")
    public List<JobAdvertisementDTO> findAll(@RequestParam int page, @RequestParam int size) {
        return jobService.getAll();
    }

    @GetMapping("/getLastTop10")
    public List<JobAdvertisementDTO> findLastTop10Advertisement(){
        return jobService.findLastTop10Advertisement();
    }


}
