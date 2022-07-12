package alumnimanagement.controller;

import alumnimanagement.entity.authUser.AdminRole;
import alumnimanagement.entity.authUser.FacultyRole;
import alumnimanagement.entity.authUser.StudentRole;
import alumnimanagement.entity.authUser.UserAuth;
import alumnimanagement.services.impl.UserAuthServiceImpl;
import alumnimanagement.utility.Helper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@CrossOrigin
public class UaaController {
    @Autowired
    Helper helper;
    @Autowired
    private UserAuthServiceImpl userService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/saveAdmin")
    public String saveAdmin(@RequestBody AdminRole user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "Saved Successfully";
    }

    @PutMapping("/edit")
    public String edit(@RequestBody UserAuth user) {
        UserAuth editUser = userService.getById(user.getId());
        editUser.setUsername(user.getUsername());
        String role = editUser.getRole().toUpperCase();
        if (role.toUpperCase().equals("ADMIN")) {
            AdminRole admin = (AdminRole) editUser;
            userService.save(admin);
        } else {
            StudentRole normal = (StudentRole) editUser;
            userService.save(normal);
        }
        return "Saved Successfully";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody StudentRole user) {
        userService.save(user);
        return "Saved Successfully";
    }

    @GetMapping("/get/{id}")
    public UserAuth getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/getRoleById/{id}")
    public String getRoleById(@PathVariable Long id) {
        return userService.getRoleById(id);
    }

    @GetMapping("/getUserByName/{userName}")
    public UserAuth getUserByName(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }

    @GetMapping("/loadUserByUsername/{userName}")
    public UserDetails loadUserByUsername(@PathVariable String userName) {
        var result = userService.loadUserByUsername(userName);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        userService.deletById(id);
        return "Deleted Successfully";
    }

    @PutMapping("/profile")
    public void editUser(@RequestBody UserAuth userAuth) {
        Long id = helper.getLoggedUserId();
        var user =userService.getById(id);
        switch (user.getRole().toUpperCase())
        {
            case "FACULTY":
                FacultyRole fr = new FacultyRole();
                fr.setPassword(passwordEncoder.encode(userAuth.getPassword()));
                fr.setUsername(userAuth.getUsername());
                fr.setActive(true);
                fr.setId(id);
                userService.save(fr);
                break;

            case"STUDENT":
                StudentRole st=new StudentRole();
                st.setPassword(passwordEncoder.encode(userAuth.getPassword()));
                st.setUsername(userAuth.getUsername());
                st.setActive(true);
                st.setId(id);
                userService.save(st);
                break;

            case"ADMIN":
                AdminRole admin=new AdminRole();
                admin.setPassword(passwordEncoder.encode(userAuth.getPassword()));
                admin.setUsername(userAuth.getUsername());
                admin.setActive(true);
                admin.setId(id);
                userService.save(admin);
                break;
        }
    }
}
