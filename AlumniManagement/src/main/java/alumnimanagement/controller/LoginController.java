package alumnimanagement.controller;

import alumnimanagement.dto.UserDto;
import alumnimanagement.entity.authUser.FacultyRole;
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

    @Autowired
    private UserAuthServiceImpl userService;
    private PasswordEncoder passwordEncoder;
    @PostMapping()
    public String authenticate(@RequestBody UserAuth jwtRequest) throws Exception {
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
        return token;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto){

        switch (userDto.getRole().toUpperCase())
        {
            case "FACULTY":
                FacultyRole fr = new FacultyRole();
                fr.setPassword(passwordEncoder.encode(userDto.getPassword1()));
                userService.save(fr);
                break;
        }

        return " ";
    }

}
