package edu.miu.amp.repository;

import edu.miu.amp.domain.Student;
import edu.miu.amp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(@NotBlank String username);


    @Query("SELECT s from Student s group by s.department")
    Optional<Student> findStudentByDepartment(Student student);


}
