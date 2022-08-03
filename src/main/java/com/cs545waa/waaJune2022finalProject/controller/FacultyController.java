package com.cs545waa.waaJune2022finalProject.controller;


import com.cs545waa.waaJune2022finalProject.dto.FacultyDto;
import com.cs545waa.waaJune2022finalProject.dto.StudentDto;
import com.cs545waa.waaJune2022finalProject.entity.Faculty;
import com.cs545waa.waaJune2022finalProject.service.FacultyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.keycloak.KeycloakPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/faculties")
@Data
@AllArgsConstructor
public class FacultyController {
    private final FacultyService facultyService;

    //    ------------   registering to the system  -----------------
    @PostMapping
    public void createUser(@RequestBody FacultyDto faculty, Principal principal){
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
//        user.getKeycloakSecurityContext().getToken().getName();
        facultyService.registerFaculty(faculty);
    }


    // --------------------   get faculty -----------------------
    @GetMapping
    public FacultyDto get(Principal principal){
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username=user.getKeycloakSecurityContext().getToken().getPreferredUsername();
        return facultyService.getFacultyByUsername(username);
    }

    //    ------------   edit profile ----------------------------------
    @PutMapping("/edit-profile")
    public void editProfile(@RequestBody FacultyDto facultyDto, Principal principal) {
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
         int id = Integer.valueOf(user.getKeycloakSecurityContext().getToken().getId());

        facultyService.editProfile(facultyDto, id);
    }


}
