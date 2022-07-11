package alumnimanagement.controller;

import alumnimanagement.dto.AppliedJobDTO;
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

}
