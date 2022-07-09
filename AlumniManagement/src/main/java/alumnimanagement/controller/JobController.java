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

    @PostMapping("/newJob")
    public void addJobPost(@RequestBody JobAdvertisementDTO jobAdvertisementDTO){jobService.create(jobAdvertisementDTO);}

    @GetMapping("/getAll")
    public List<JobAdvertisementDTO> findAll(@RequestParam int page, @RequestParam int size) {
        return jobService.getAll();
    }

    @GetMapping("/getLastTop10")
    public List<JobAdvertisementDTO> findLastTop10Advertisement(){
        return jobService.findLastTop10Advertisement();
    }


}
