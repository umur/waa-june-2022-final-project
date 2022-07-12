package com.cs545waa.waaJune2022finalProject.controller;

import com.cs545waa.waaJune2022finalProject.Exceptions.RecordNotFoundException;
import com.cs545waa.waaJune2022finalProject.dto.JobADvertismentGetDTO;
import com.cs545waa.waaJune2022finalProject.dto.JobAdvertisementDto;
import com.cs545waa.waaJune2022finalProject.dto.PagingRequest;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import com.cs545waa.waaJune2022finalProject.service.JobService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobAdvertisementController {

    private final JobService jobService;
    private final ModelMapper modelmapper;

    //------------------------------ filter job advertisement  -------------

    @GetMapping("/filter")
    public List<JobAdvertisementDto> filter(@RequestParam(name = "tag", required = false) String tag,
                                            @RequestParam(name = "state",required = false) String state,
                                            @RequestParam(name = "city", required = false) String city,
                                            @RequestParam(name = "companyName", required = false) String companyName) {

        return jobService.filter(tag, state, city, companyName);
    }

    @GetMapping
    public List<JobAdvertisementDto> getJobAdvertisements(){
        return jobService.getJobAllAdvertisements();
    }


    @PostMapping("/paginated")
    public Page<JobADvertismentGetDTO> getAllPaginatedAdv(@RequestBody PagingRequest pagingRequest) {
        return mapEntityPageIntoDtoPage(jobService.getAllJobAdvPaginated(pagingRequest), JobADvertismentGetDTO.class);

    }
    @PostMapping(consumes = { "application/Json" ,"multipart/form-data" })
    public void createJobAdvertisement(@RequestPart("jobadvertisement") JobAdvertisement jobAdvertisement , @RequestPart("file") MultipartFile file) throws RecordNotFoundException {
        jobService.saveJobAdvertisement(jobAdvertisement , file);

    }
    @GetMapping("/{id}")
    public JobADvertismentGetDTO getById(@PathVariable int id){

        return jobService.getById(id);
    }

    public <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass) {
        return entities.map(objectEntity -> modelmapper.map(objectEntity, dtoClass));
    }
}
