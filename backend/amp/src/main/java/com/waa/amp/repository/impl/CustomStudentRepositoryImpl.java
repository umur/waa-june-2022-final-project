package com.waa.amp.repository.impl;

import com.waa.amp.dto.StudentSearchReq;
import com.waa.amp.entity.Student;
import com.waa.amp.repository.CustomStudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import java.util.List;

import static com.waa.amp.utils.Utils.isNotBlank;

@RequiredArgsConstructor
@Slf4j
public class CustomStudentRepositoryImpl implements CustomStudentRepository {

    private final EntityManager entityManager;

    @Override
    public List<Student> searchStudent(StudentSearchReq studentSearchReq) {
        String sql = " select * from student where 1 = 1 ";

        if (isNotBlank(studentSearchReq.city())) {
            sql += " and city = '" + studentSearchReq.city() + "' ";
        }
        if (isNotBlank(studentSearchReq.major())) {
            sql += " and major = '" + studentSearchReq.major() + "' ";
        }

        if (isNotBlank(studentSearchReq.firstname())) {
            sql += " and firstname = '" + studentSearchReq.firstname() + "' ";
        }

        if (isNotBlank(studentSearchReq.lastname())) {
            sql += " and lastname = '" + studentSearchReq.lastname() + "' ";
        }

        log.info("sql : {}", sql);

        List<Student> resultList = (List<Student>) entityManager.createNativeQuery(sql, Student.class).getResultList();

        return resultList;
    }


}
