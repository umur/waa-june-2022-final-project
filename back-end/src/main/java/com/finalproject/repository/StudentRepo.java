package com.finalproject.repository;

import com.finalproject.models.Student;
import com.finalproject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

    User findByUser_Id(Long id);

    User findByUserId(Long id);



}
