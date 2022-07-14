package com.example.alumni.service;



import com.example.alumni.dto.user.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllStudents();

    List<UserDto> getAllFaculty();

    UserDto getUserById(Long id);


}
