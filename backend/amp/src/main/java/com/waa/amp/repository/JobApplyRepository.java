package com.waa.amp.repository;

import com.waa.amp.entity.JobApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplyRepository extends JpaRepository<JobApply, Long> {
}
