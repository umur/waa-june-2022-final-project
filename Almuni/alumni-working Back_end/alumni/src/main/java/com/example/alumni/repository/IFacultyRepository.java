package com.example.alumni.repository;


import com.example.alumni.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacultyRepository extends JpaRepository<Faculty,Long> {

    Faculty findByEmail(String userName);

}
