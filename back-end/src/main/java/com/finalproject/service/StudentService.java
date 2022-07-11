package com.finalproject.service;

import com.finalproject.models.Student;
import com.finalproject.models.User;
import com.finalproject.payload.request.PostRequest;

import java.util.List;

public interface StudentService {
    List<User> findAllStudent();

    User findById(long id) throws Exception;
    Student getbyId(Long id) throws Exception;

    void post(PostRequest postRequest, long id);
    List<Student>getByCity(String city);
    List<Student>getByState(String state);
    List<Student>getByMajor(String major);
    Student getByStudentId(Integer id) throws Exception;
    List<Student> getByName(String name);
    void deleteStudent(Long id);


}
