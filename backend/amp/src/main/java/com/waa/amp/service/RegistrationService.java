package com.waa.amp.service;

import com.waa.amp.dto.CheckUsernameReq;
import com.waa.amp.dto.CreateUserReq;
import com.waa.amp.entity.Faculty;
import com.waa.amp.entity.Student;
import com.waa.amp.entity.User;
import com.waa.amp.entity.UserType;
import com.waa.amp.repository.FacultyRepository;
import com.waa.amp.repository.RoleRepository;
import com.waa.amp.repository.StudentRepository;
import com.waa.amp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    public boolean checkUsername(CheckUsernameReq checkUsernameReq) {
        User user = userRepository.findByEmail(checkUsernameReq.username()).orElse(null);
        return user != null;
    }

    public boolean createUser(CreateUserReq createUserReq) {

        boolean exists = checkUsername(new CheckUsernameReq(createUserReq.username()));

        if (exists) {
            return false;
        }

        User user = new User(null,
                createUserReq.username(),
                createUserReq.password(),
                createUserReq.userType() == UserType.STUDENT ? List.of(roleRepository.findByCode("STUDENT")) :  List.of(roleRepository.findByCode("FACULTY")),
                createUserReq.userType(),
                false,
                LocalDateTime.now()
                );

        User save = userRepository.save(user);

        if (createUserReq.userType() == UserType.STUDENT) {
            Student student = new Student(save, createUserReq.firstname(), createUserReq.lastname(), createUserReq.city());
            studentRepository.save(student);
        } else {
            Faculty faculty = new Faculty(save, createUserReq.firstname(), createUserReq.lastname(), createUserReq.city());
            facultyRepository.save(faculty);
        }

        return true;
    }


}
