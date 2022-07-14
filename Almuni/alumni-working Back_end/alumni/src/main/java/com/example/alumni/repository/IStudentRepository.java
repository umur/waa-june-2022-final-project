package com.example.alumni.repository;


import com.example.alumni.entity.Department;
import com.example.alumni.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student as s where s.address.state=?1")
    List<Student> findStudentsByState(String state);
    @Query("select s from Student as s where s.address.city=?1")
    List<Student> findStudentsByCity(String city);
    List<Student> findStudentByMajor(Department major);
    Student findByEmail(String name);

}
