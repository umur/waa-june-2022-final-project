package alumnimanagement.controller;

import alumnimanagement.dto.JobAdvertisementDTO;
import alumnimanagement.services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job")
@AllArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping
    public List<JobAdvertisementDTO> findAll() {
        return jobService.getAll();
    }


}
