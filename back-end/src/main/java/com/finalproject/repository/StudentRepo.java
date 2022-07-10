package com.finalproject.repository;

import com.finalproject.models.Student;
import com.finalproject.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

    User findByUser_Id(Long id);


     Student findByStudentId(Integer id);
    List<Student>findAllByMajor(String major);
    List<Student >findAllByAddress_City(String city);
    List<Student>findAllByAddress_State(String state);
//    List<Student>findAllByName()



}
