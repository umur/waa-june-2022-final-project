package com.finalproject.repository;

import com.finalproject.models.Applied;
import com.finalproject.models.JobAdvertisement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppliedRepository extends CrudRepository<Applied ,Long> {

    @Query("select f from Applied as f  order by f.dayofApplied desc ")
    List<Applied> findAllByApplied();
}
