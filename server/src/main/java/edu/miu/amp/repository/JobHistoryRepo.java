package edu.miu.amp.repository;

import edu.miu.amp.domain.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobHistoryRepo extends JpaRepository<JobHistory, Integer> {

}
