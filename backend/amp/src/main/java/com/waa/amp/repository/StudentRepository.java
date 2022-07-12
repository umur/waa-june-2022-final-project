package com.waa.amp.repository;

import com.waa.amp.entity.Student;
import com.waa.amp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, CustomStudentRepository {

    Student findByIdAndUser(Long id, User user);

    Student findByUser(User user);

}
