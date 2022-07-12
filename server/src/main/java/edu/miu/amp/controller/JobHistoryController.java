package edu.miu.amp.controller;


import edu.miu.amp.dto.JobHistoryDto;


import edu.miu.amp.service.JobHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/job-history")
@CrossOrigin
public class JobHistoryController {

    private JobHistoryService jobHistoryService;

    public JobHistoryController(JobHistoryService jobHistoryService) {
        this.jobHistoryService = jobHistoryService;
    }

    @GetMapping
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<List<JobHistoryDto>> getAllJobHistory() {
        var res = jobHistoryService.getAllJobHistory();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<JobHistoryDto> addJobHistory(@Valid @RequestBody JobHistoryDto data
    ) {
        var res = jobHistoryService.addJobHistory(data);

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<JobHistoryDto> getJobHistory(@PathVariable(name = "id") Integer id) {

        var res = jobHistoryService.getJobHistory(id);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<JobHistoryDto> updateJobHistory(@PathVariable(name = "id") Integer id, @RequestBody JobHistoryDto data) {

        var res = jobHistoryService.updateJobHistory(id, data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed({"student", "faculty"})
    public void deleteJobHistory(@PathVariable(name = "id") Integer id) {

        jobHistoryService.deleteJobHistory(id);
    }


}
