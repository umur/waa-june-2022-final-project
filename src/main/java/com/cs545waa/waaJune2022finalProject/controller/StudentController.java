package com.cs545waa.waaJune2022finalProject.controller;


import com.cs545waa.waaJune2022finalProject.dto.CvDto;
import com.cs545waa.waaJune2022finalProject.dto.JobAdvertisementDto;
import com.cs545waa.waaJune2022finalProject.dto.ProfessionalExperienceDto;
import com.cs545waa.waaJune2022finalProject.dto.StudentDto;
import com.cs545waa.waaJune2022finalProject.service.CvService;
import com.cs545waa.waaJune2022finalProject.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.keycloak.KeycloakPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/students")
@Data
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    StudentService studentService;
    CvService cvService;


   //    ------------   registering to the system  -----------------
    @PostMapping
    public void save(@RequestBody StudentDto a, Principal principal){
        KeycloakPrincipal user=(KeycloakPrincipal)principal;

        user.getKeycloakSecurityContext().getToken().getName();
        studentService.registerStudent(a);
    }

    // --------------------   get student -----------------------
    @GetMapping
    public ResponseEntity<StudentDto> get(Principal principal){
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username=user.getKeycloakSecurityContext().getToken().getPreferredUsername();
        return ResponseEntity.ok().body(studentService.getStudentByUsername(username));
    }
    @GetMapping("/get")
    public ResponseEntity<String> getStudents(Principal principal){

        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username=user.getKeycloakSecurityContext().getToken().getPreferredUsername();
        return ResponseEntity.ok().body("HI");
    }

    //------------------------------ edit profile -------------
    @PutMapping("/save-profile")
    public void saveProfile(@RequestBody StudentDto studentDto, Principal principal ) {
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        int id = studentService.getStudentByUsername(
                user
                .getKeycloakSecurityContext()
                .getToken().getPreferredUsername()).getId();

        studentService.editProfile(studentDto, id);
    }
    //------------------------------ get cv -------------
    // when student clicks edit cv or wants to create cv

    @GetMapping("/edit-cv")
    public CvDto editCv(Principal principal) {
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username = user.getKeycloakSecurityContext().getToken().getPreferredUsername();
        return cvService.getCv(username);
    }
    // ---------------- add professional experience---------
    @PostMapping("/add-experience")
    public void addExperience(@RequestBody ProfessionalExperienceDto professionalExperienceDto,Principal principal) {
        studentService.addExperience(professionalExperienceDto);
    }
}

