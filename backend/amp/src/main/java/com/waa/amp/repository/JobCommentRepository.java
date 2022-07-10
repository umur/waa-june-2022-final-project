package com.waa.amp.repository;

import com.waa.amp.entity.JobComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCommentRepository extends JpaRepository<JobComment, Long> {
}
