package edu.miu.amp.repository;

import edu.miu.amp.domain.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {

    public List<JobAdvertisement> findTop10ByOrderByIdDesc() ;
}
