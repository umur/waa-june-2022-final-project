package alumnimanagement.controller;

import alumnimanagement.dto.JobAdvertisementDTO;
import alumnimanagement.dto.JobAdvertisementListDTO;
import alumnimanagement.dto.StudentListDto;
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

    @GetMapping()
    public List<JobAdvertisementDTO> findAll() {
        return jobService.getAll();
    }

    @GetMapping("/getLastTop10")
    public List<JobAdvertisementDTO> findLastTop10Advertisement(){
        return jobService.findLastTop10Advertisement();
    }

    @GetMapping("/getAll")
    public List<JobAdvertisementListDTO> findAllList(@RequestParam int page, @RequestParam int size, @RequestParam String searchValue)
    {
        var result = jobService.findAllByParam(page,size,searchValue);
        return result;
    }

    @GetMapping("/count")
    public Long count() {
        return jobService.count();
    }
}
