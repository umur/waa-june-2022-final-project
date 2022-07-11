package edu.miu.amp.repository;

import edu.miu.amp.domain.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {


    //@Query("SELECT TOP 25 a FROM Arcust a WHERE a.arcustno<='?1' ORDER BY a.arcustno DESC")


//    @Query ("SELECT a FROM JobAdvertisement  a where a.id <='?1' ORDER BY a.id DESC")
    public List<JobAdvertisement> findTop10ByOrderById() ;


}
