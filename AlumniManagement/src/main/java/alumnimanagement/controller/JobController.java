package alumnimanagement.controller;

import alumnimanagement.dto.JobAdvertisementDTO;
import alumnimanagement.services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public void addJobPost(@RequestBody JobAdvertisementDTO jobAdvertisementDTO){jobService.create(jobAdvertisementDTO);}

    @GetMapping("/getAll")
    public List<JobAdvertisementDTO> findAll(@RequestParam int page, @RequestParam int size) {
        return jobService.getAll();
    }

}
