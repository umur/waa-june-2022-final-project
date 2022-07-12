package alumnimanagement.controller;

import alumnimanagement.dto.JobAdvertisementDTO;
import alumnimanagement.dto.JobAdvertisementListDTO;
import alumnimanagement.dto.ReportList;
import alumnimanagement.dto.StudentListDto;
import alumnimanagement.entity.job.JobAdvertisement;
import alumnimanagement.services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping("/newJob")
    public void addJobPost(@RequestBody JobAdvertisementDTO jobAdvertisementDTO)
    {
        jobService.create(jobAdvertisementDTO);
    }

    @GetMapping()
    public List<JobAdvertisementDTO> findAll() {
        return jobService.getAll();
    }

    @GetMapping("/getLastTop10")
    public List<JobAdvertisementDTO> findLastTop10Advertisement(){
        return jobService.findLastTop10Advertisement();
    }

    @GetMapping("/{state}/{city}/{tag}/{name}/getAll")
    public List<JobAdvertisementListDTO> getAll(@PathVariable String state, @PathVariable String city,@PathVariable String tag,@PathVariable String name,@RequestParam int page, @RequestParam int size, @RequestParam String searchValue)
    {
        if(state.equals("undefined"))
            state = "''";
        if(city.equals("undefined"))
            city = "''";
        if(tag.equals("undefined"))
            tag = "''";
        if(name.equals("undefined"))
            name = "''";
        var result = jobService.findAllByParam(page,size,state, city, tag, name);
        return result;
    }

    @GetMapping("/{state}/{city}/{tag}/{name}/count")
    public Long count(@PathVariable String state, @PathVariable String city,@PathVariable String tag,@PathVariable String name)
    {
        if(state.equals("undefined"))
            state = "''";
        if(city.equals("undefined"))
            city = "''";
        if(tag.equals("undefined"))
            tag = "''";
        if(name.equals("undefined"))
            name = "''";
        return jobService.count(state, city, tag, name);
    }

    @GetMapping("/{id}")
    public JobAdvertisementDTO getJobsById(@PathVariable int id){
        return jobService.findById(id);
    }

    @GetMapping("/{id}/getAll")
    public List<JobAdvertisementDTO> findStudentJobList(@PathVariable long id,@RequestParam int page, @RequestParam int size, @RequestParam String searchValue)
    {
        var result = jobService.findStudentJobList(id,page,size,searchValue);
        return result;
    }

    @GetMapping("/{id}/count")
    public Long count(long id)
    {
        return jobService.countById(id);
    }

    @PutMapping("/updateJob/{jobId}")
    public void updateJob(@PathVariable int jobId, @RequestBody JobAdvertisementDTO jobAdvertisementDTO){
        System.out.println("here ==================================="+ jobId);
        jobService.update(jobAdvertisementDTO, jobId);
    }

    @GetMapping("/getByTags")
    public List<ReportList> getJobsByTags(){
        return jobService.findByTags();

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        jobService.delete(id);
    }

    @GetMapping("/getByStateTag/{state}")
    public List<ReportList> jobsByStateTag(@PathVariable String state){
        return jobService.jobsByStateTag(state);
    }
}
