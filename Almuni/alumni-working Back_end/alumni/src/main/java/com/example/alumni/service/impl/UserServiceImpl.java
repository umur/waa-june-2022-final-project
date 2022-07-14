package com.example.alumni.service.impl;


import com.example.alumni.dto.FacultyDto;
import com.example.alumni.dto.StudentDto;
import com.example.alumni.dto.request.LoginRequest;
import com.example.alumni.dto.request.RegistrationRequest;
import com.example.alumni.dto.response.LoginResponse;
import com.example.alumni.dto.response.MessageResponse;
import com.example.alumni.dto.response.RegistrationResponse;
import com.example.alumni.dto.user.UserDto;
import com.example.alumni.entity.ERole;
import com.example.alumni.entity.Role;
import com.example.alumni.entity.Student;
import com.example.alumni.entity.User;
import com.example.alumni.exception.custom.UserNotFoundException;
import com.example.alumni.repository.UserRepository;
//import com.example.alumni.security.JwtHelper;
import com.example.alumni.service.IUserService;
import com.example.alumni.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository iUserRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllStudents() {
        var allStudents = iUserRepository.findAll();

        List<User>  users = allStudents.stream()
                .filter(stu -> {
                    List<String> roles = stu.getRoles().stream()
                            .map(r -> r.getName().toString())
                            .collect(Collectors.toList());
                    return roles.contains("ROLE_STUDENT");
                }).collect(Collectors.toList());

        Type list =new TypeToken<List<StudentDto>>(){}.getType();

        return modelMapper.map(users,list);
    }

    @Override
    public List<UserDto> getAllFaculty() {

        var allFaculties = iUserRepository.findAll();

        List<User>  users = allFaculties.stream()
                .filter(stu -> {
                    List<String> roles = stu.getRoles().stream()
                            .map(r -> r.getName().toString())
                            .collect(Collectors.toList());
                    return roles.contains("ROLE_FACULTY");
                }).collect(Collectors.toList());

        Type list =new TypeToken<List<FacultyDto>>(){}.getType();

        return modelMapper.map(users,list);
    }

    @Override
    public UserDto getUserById(Long id) {

        var user = iUserRepository.findById(id);
        return modelMapper.map(user,UserDto.class);
    }


//
//
//
//    @Override
//    @Transactional
//    public List<RegistrationResponse> findAll() {
//
//        var username = SecurityContextHolder.getContext().getAuthentication().getName();
//
//        log.info("Login with user: {}",username);
//        var user = iUserRepository.findByEmail(username);
//
//        var users = (List<User>) iUserRepository.findAll();
//        users = users
//                .stream()
//                .filter(u -> !u.getId().equals(user.getId())).collect(Collectors.toList());
//
//        Type listType = new TypeToken<List<RegistrationResponse>>(){}.getType();
//        return modelMapper.map(users,listType);
//    }
//
//
//    @Override
//    public RegistrationResponse findById(Long id) {
//        User user = iUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("User does not exist %s",id)));
//        return modelMapper.map(iUserRepository.save(user), RegistrationResponse.class);
//    }
//
//
//    @Override
//    public LoginResponse login(LoginRequest loginRequest) {
//        Authentication authentication= null;
//        try {
//            authentication =authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
//                            loginRequest.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            throw new UserNotFoundException("Bad Credentials");
//        }
//
//        String role = authentication.getAuthorities().stream().findFirst().get().getAuthority();
//        final String accessToken = jwtHelper.generateToken(loginRequest.getUserName(), role);
//        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getPassword());
//        var loginResponse = new LoginResponse(accessToken, refreshToken);
//        System.out.println("signed succesfully - in login method " + loginResponse);
//
//        return loginResponse;
//    }
//
//    @Override
//    public RegistrationResponse findByEmail(String email) {
//        User user = iUserRepository.findByEmail(email);
//        if (user == null) {
//            throw new UserNotFoundException("User not Found");
//        }
//        return modelMapper.map(user, RegistrationResponse.class);
//    }
//
//
//    @Override
//    public void userIsActive(long id) {
//        User user = iUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("User does not exist %s", id)));
//        var status = user.isActive() ? false : true;
//        user.setActive(status);
//        iUserRepository.save(user);
//    }
//
//
////    public void sendEmail(String recipientEmail, String link)
////            throws MessagingException, UnsupportedEncodingException {
////        MimeMessage message = mailSender.createMimeMessage();
////        MimeMessageHelper helper = new MimeMessageHelper(message);
////
////
////        helper.setFrom("bibek.karki001@gmail.com", "check it out");
////        helper.setTo(recipientEmail);
////
////        String subject = "Here's the link to reset your password";
////
////        String content = "<p>Hello,</p>"
////                + "<p>You have requested to reset your password.</p>"
////                + "<p>Click the link below to change your password:</p>"
////                + "<a href=\"" + link + "\">Change my password</a>"
////                + "<br>"
////                + "<p>Ignore this email if you do remember your password, "
////                + "or you have not made the request.</p>";
////
////        helper.setSubject(subject);
////
////        helper.setText(content, true);
////
////        mailSender.send(message);
////    }

}
