package com.waa.amp.repository;

import com.waa.amp.dto.StudentSearchReq;
import com.waa.amp.entity.Student;

import java.util.List;

public interface CustomStudentRepository {

    List<Student> searchStudent(StudentSearchReq studentSearchReq);

}
