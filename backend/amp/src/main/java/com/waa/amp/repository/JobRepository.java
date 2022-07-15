package com.waa.amp.repository;

import com.waa.amp.entity.Job;
import com.waa.amp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>, CustomJobRepository {

    List<Job> findAllByPostedBy(User user);

    Optional<Job> findByIdAndPostedBy(Long id, User user);

}
