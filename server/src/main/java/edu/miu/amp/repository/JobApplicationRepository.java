package edu.miu.amp.repository;

import edu.miu.amp.domain.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
    public List<JobApplication> findTop10ByOrderByIdDesc() ;


}
