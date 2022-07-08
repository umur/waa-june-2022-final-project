package com.cs545waa.waaJune2022finalProject.controller;


import com.cs545waa.waaJune2022finalProject.dto.CvDto;
import com.cs545waa.waaJune2022finalProject.dto.ProfessionalExperienceDto;
import com.cs545waa.waaJune2022finalProject.dto.StudentDto;
import com.cs545waa.waaJune2022finalProject.service.CvService;
import com.cs545waa.waaJune2022finalProject.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/edit-profile/{id}")
    public void editProfile(@PathVariable int id, @RequestBody StudentDto studentDto) {
        studentService.editProfile(studentDto);
    }

    //------------------------------ create cv -------------
    @PostMapping("/create-cv/{id}")
    public void createCv(@PathVariable int id, @RequestBody CvDto cvDto) {
//        cvService.createCv(cvDto);
        cvService.createCv(cvDto);

    }

    //------------------------------ edit cv -------------
    @PostMapping("/edit-cv/{id}")
    public void editCv(@PathVariable int id, @RequestBody CvDto cvDto) {
        cvService.editCv(cvDto);
    }

    // ---------------- add professional experience---------
    @PostMapping("/add-experience/{id}")
    public void addExperience(@PathVariable int id, @RequestBody ProfessionalExperienceDto professionalExperienceDto) {
        studentService.addExperience(professionalExperienceDto);
    }


    //------------------------------------------------------
    @PostMapping("")
    public void save(@RequestBody StudentDto a){
        studentService.registerStudent(a);
    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable int id){
//        studentService.delete(id);
//    }
//
//    @PutMapping("/{id}")
//    public  void update(@PathVariable int id, @RequestBody Student p){
//        studentService.update(id,p);

    //-----------------------------------------------------------

}

