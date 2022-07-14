package com.example.almuni.repository;

import com.example.almuni.entity.Department;
import com.example.almuni.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("select s from Student as s where s.address.state=?1")
    List<Student> findStudentsByState(String state);
    @Query("select s from Student as s where s.address.city=?1")
    List<Student> findStudentsByCity(String city);
    List<Student> findStudentByMajor(Department major);

}
