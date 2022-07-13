package edu.miu.amp.repository;


import edu.miu.amp.domain.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends JpaRepository<ActivityLog, Integer> {

}
