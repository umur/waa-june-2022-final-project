package alumnimanagement.controller;

import alumnimanagement.dto.AppliedJobDTO;
import alumnimanagement.dto.AppliedStudentsDTO;
import alumnimanagement.services.AppliedJobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs/apply")
@AllArgsConstructor
@CrossOrigin
public class AppliedJobController {
    private final AppliedJobService appliedJobService;

    @PostMapping
    public void createJobApply(@RequestBody AppliedJobDTO appliedJobDTO) {
        System.out.println(appliedJobDTO);
        appliedJobService.create(appliedJobDTO);
    }

    @GetMapping("/{studentId}")
    public List<AppliedJobDTO> findAppliedJobByStudentId(@PathVariable Long studentId) {
        return appliedJobService.findAppliedJobByStudentId(studentId);
    }

    @DeleteMapping("/{appliedJobId}")
    public void removeAppliedJob(@PathVariable Long appliedJobId) {
        appliedJobService.remove(appliedJobId);
    }

    @GetMapping("/by/{jobId}/getAll")
    public List<AppliedStudentsDTO> findStudentsAppliedToJob(@PathVariable int jobId,@RequestParam int page, @RequestParam int size, @RequestParam String searchValue) {
        System.out.println("here==========================>");
        return appliedJobService.findStudentsJobAppliedToJob(jobId,page,size,searchValue);
    }

    @GetMapping("/by/{jobId}/count")
    public Long count(int id)
    {
        return appliedJobService.countById(id);
    }



}
