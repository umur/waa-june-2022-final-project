package com.waa.amp.repository;

import com.waa.amp.entity.Student;
import com.waa.amp.entity.StudentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCommentRepository extends JpaRepository<StudentComment, Long> {

    StudentComment findByStudent(Student student);

}
