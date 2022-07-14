package com.cs545waa.waaJune2022finalProject.controller;

import com.cs545waa.waaJune2022finalProject.Exceptions.RecordNotFoundException;
import com.cs545waa.waaJune2022finalProject.dto.*;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import com.cs545waa.waaJune2022finalProject.service.JobService;
import com.cs545waa.waaJune2022finalProject.service.StudentService;
import lombok.AllArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
@CrossOrigin("*")
public class JobAdvertisementController {

    private final JobService jobService;
    private final StudentService studentService;
    private final ModelMapper modelmapper;

    //------------------------------ filter job advertisement  -------------

    @GetMapping("/filter")
    public ResponseEntity<List<JobAdvertisementDto>> filter(@RequestParam(name = "tag", required = false) String tag,
                                            @RequestParam(name = "state",required = false) String state,
                                            @RequestParam(name = "city", required = false) String city,
                                            @RequestParam(name = "companyName", required = false) String companyName) {

        return ResponseEntity.ok().body(jobService.filter(tag, state, city, companyName));
    }

    @GetMapping
    public ResponseEntity<List<JobAdvertisementDto>> getAllJobAdvertisements( Principal principal){
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username=user.getKeycloakSecurityContext().getToken().getPreferredUsername();

        return ResponseEntity.ok().body(jobService.getAllJobAdvertisements(username));
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


    // charts

    @GetMapping("/companiescount")
    public List<JobCount> countTotalJobsByCompanyName()
    {
        return jobService.countTotalJobsByCompanyName();
    }

    @GetMapping("/tagscount")
    public List<TagCount> countTotalTags()
    {
        return jobService.countTotalTagsByName();
    }
}
