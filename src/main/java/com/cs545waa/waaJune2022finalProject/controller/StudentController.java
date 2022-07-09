package com.cs545waa.waaJune2022finalProject.controller;


import com.cs545waa.waaJune2022finalProject.dto.CvDto;
import com.cs545waa.waaJune2022finalProject.dto.ProfessionalExperienceDto;
import com.cs545waa.waaJune2022finalProject.dto.StudentDto;
import com.cs545waa.waaJune2022finalProject.service.CvService;
import com.cs545waa.waaJune2022finalProject.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.keycloak.KeycloakPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/students")
@Data
@AllArgsConstructor

public class StudentController {

    StudentService studentService;
    CvService cvService;


    //====================  using pathvariable id until integrate with keyclock
    // ============= just for testing purposes

    //------------------------------ edit profile -------------
    @PutMapping("/edit-profile")
    public void editProfile(@RequestBody StudentDto studentDto, Principal principal) {
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username=user.getKeycloakSecurityContext().getToken().getPreferredUsername();

        studentService.editProfile(studentDto);
    }

    //------------------------------ create cv -------------
    @PostMapping("/create-cv")
    public void createCv(@RequestBody CvDto cvDto, Principal principal) {
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username=user.getKeycloakSecurityContext().getToken().getPreferredUsername();

//        cvService.createCv(cvDto);
        cvService.createCv(cvDto);

    }

    //------------------------------ edit cv -------------
    @PostMapping("/edit-cv")
    public void editCv( @RequestBody CvDto cvDto, Principal principal) {
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username=user.getKeycloakSecurityContext().getToken().getPreferredUsername();

        cvService.editCv(cvDto);
    }

    // ---------------- add professional experience---------
    @PostMapping("/add-experience")
    public void addExperience(@RequestBody ProfessionalExperienceDto professionalExperienceDto) {
        studentService.addExperience(professionalExperienceDto);
    }


    //------------------------------------------------------
    @PostMapping
    public void save(@RequestBody StudentDto a, Principal principal){
        KeycloakPrincipal user=(KeycloakPrincipal)principal;

        user.getKeycloakSecurityContext().getToken().getName();
        studentService.registerStudent(a);
    }

    @GetMapping
    public StudentDto get(Principal principal){
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username=user.getKeycloakSecurityContext().getToken().getPreferredUsername();
        return studentService.getStudentByUsername(username);
    }
}

