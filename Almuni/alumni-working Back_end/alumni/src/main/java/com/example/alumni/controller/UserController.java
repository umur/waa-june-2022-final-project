package com.example.alumni.controller;

import com.example.alumni.dto.user.UserDto;
import com.example.alumni.service.IUserService;
import com.example.alumni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/miu/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    @RolesAllowed("Admin")
    public String adminAccess() {

        return "Admin Board.";
    }

    @GetMapping("/student")
    @RolesAllowed("Student")
    public String studentAccess() {

        return "Student Board.";
    }

    @GetMapping("/faculty")
    @RolesAllowed("Faculty")
    public String facultyAccess() {
        return "Faculty Board.";
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/allStudents")
    @RolesAllowed("Admin")
    public List<UserDto> getAllSellers(){
        return null; //fixme -----------------------------
    }

    @GetMapping("/allFaculty")
    @RolesAllowed("Admin")
    public List<UserDto> getAllBuyers(){

        return null; //fixme -----------------------------
    }

    @GetMapping("/{id}")
    @RolesAllowed("Admin")
    public UserDto getUserById(@PathVariable("id")Long id){
        return null; //fixme -----------------------------
    }

}
