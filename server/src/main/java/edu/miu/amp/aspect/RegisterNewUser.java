package edu.miu.amp.aspect;

import edu.miu.amp.domain.Faculty;
import edu.miu.amp.domain.Student;
import edu.miu.amp.domain.User;
import edu.miu.amp.repository.FacultyRepository;
import edu.miu.amp.repository.StudentRepo;
import edu.miu.amp.repository.UserRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.keycloak.KeycloakPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class RegisterNewUser {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private StudentRepo studentRepo;


    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping ) ||" +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping) ")
    public void registerNewUser(JoinPoint joinPoint) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            var principal = (KeycloakPrincipal) authentication.getPrincipal();
            var securityContext = principal.getKeycloakSecurityContext();
            var token = securityContext.getToken();

            var existingUser = userRepo.findByUserName(token.getPreferredUsername()).orElse(null);

            var roles = token.getRealmAccess().getRoles();

            try {
                if (existingUser == null) {
                    if (roles.contains("faculty")) {
                        var newUser = new Faculty();
                        newUser.setEmail(token.getEmail());
                        newUser.setUserName(token.getPreferredUsername());
                        newUser.setFirstName(token.getName());
                        newUser.setLastName(token.getFamilyName());
                        facultyRepository.save(newUser);
                    }
                    if (roles.contains("student")) {
                        var newUser = new Student();
                        newUser.setEmail(token.getEmail());
                        newUser.setUserName(token.getPreferredUsername());
                        newUser.setFirstName(token.getName());
                        newUser.setLastName(token.getFamilyName());

                        studentRepo.save(newUser);
                    }
                }
            } catch (Exception e) {
                System.out.println("Couldnot register new user");
            }
        }
    }


}


