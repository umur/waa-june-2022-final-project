package com.waa.amp.repository;

import com.waa.amp.entity.Faculty;
import com.waa.amp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Faculty findByUser(User user);

}
