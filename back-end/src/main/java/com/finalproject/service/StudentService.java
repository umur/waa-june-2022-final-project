package com.finalproject.service;

import com.finalproject.models.Student;
import com.finalproject.models.User;
import com.finalproject.payload.request.PostRequest;

import java.util.List;

public interface StudentService {
    List<User> findAllStudent();

    User findById(long id);

    void post(PostRequest postRequest, long id);
}
