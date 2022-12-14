package alumnimanagement.controller;

import alumnimanagement.dto.LoginResponse;
import alumnimanagement.dto.StudentDTO;
import alumnimanagement.dto.UserDto;
import alumnimanagement.entity.authUser.AdminRole;
import alumnimanagement.entity.authUser.FacultyRole;
import alumnimanagement.entity.authUser.StudentRole;
import alumnimanagement.entity.authUser.UserAuth;
import alumnimanagement.jwt.JWTUtility;
import alumnimanagement.services.impl.UserAuthServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private UserAuthServiceImpl userAuthService;

    private String token;

    private PasswordEncoder passwordEncoder;
    @PostMapping()
    public LoginResponse authenticate(@RequestBody UserAuth jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException ex) {
            throw new Exception("INVALID CREDENTIALS", ex);
        }
        final UserAuth user = userAuthService.getUserByUserName(jwtRequest.getUsername());
        final String token = jwtUtility.generateToken(user);
        this.token = token;
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.token = token;
        loginResponse.id = user.getId();
        loginResponse.Role = user.getRole();
        switch (user.getRole().toUpperCase())
        {
            case "FACULTY":
                loginResponse.isFaculty=true;
                break;
            case"STUDENT":
                loginResponse.isStudent=true;
                break;
            case"ADMIN":
                loginResponse.isAdmin=true;
                break;
        }
        return loginResponse;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto){

        switch (userDto.getRole().toUpperCase())
        {
            case "FACULTY":
                FacultyRole fr = new FacultyRole();
                fr.setPassword(passwordEncoder.encode(userDto.getPassword1()));
                fr.setUsername(userDto.getName());
                fr.setActive(true);
                userAuthService.save(fr);
                break;

            case"STUDENT":
                StudentRole st=new StudentRole();
                st.setPassword(passwordEncoder.encode(userDto.getPassword1()));
                st.setUsername(userDto.getName());
                st.setActive(true);
                userAuthService.save(st);
                break;

            case"ADMIN":
                AdminRole admin=new AdminRole();
                admin.setPassword(passwordEncoder.encode(userDto.getPassword1()));
                admin.setUsername(userDto.getName());
                admin.setActive(true);
                userAuthService.save(admin);
                break;
        }

        return "Saved successfully";
    }

}
