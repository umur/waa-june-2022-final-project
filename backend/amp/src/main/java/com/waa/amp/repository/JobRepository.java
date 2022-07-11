package com.waa.amp.repository;

import com.waa.amp.entity.Job;
import com.waa.amp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findAllByPostedBy(User user);

}
