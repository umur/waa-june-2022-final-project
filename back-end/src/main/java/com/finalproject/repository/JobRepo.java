package com.finalproject.repository;

import com.finalproject.models.JobAdvertisement;
import com.finalproject.models.Tags;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends CrudRepository<JobAdvertisement, Long> {

    @Query(value="select  u.* from JobAdvertisement as u, order by u.postedDate desc LIMIT =:limit", nativeQuery=true)
   // @Query(value = "select  f.* from JobAdvertisement as f order by f.postedDate desc LIMIT=:limit", nativeQuery = true)
    List<JobAdvertisement> findAllByPostedDate(@Param("limit") int limit);
    @Query(value = "select f.*  from JobAdvertisement as f  order by f.countApplication desc LIMIT=:limit",nativeQuery = true)
    List<JobAdvertisement>findAllRecentApplied(@Param("limit")  int limit);
//@Query(value = "select  f from JobAdvertisement as f JOIN f.tags as r  where r.name=:name",nativeQuery = true)
    List<JobAdvertisement>findAllByTags_name(String  name);


//    @Query(value = "select f from JobOpening as f where f.address.state=:state",nativeQuery = true)

    List<JobAdvertisement>findAllByCity(String city);

    List<JobAdvertisement>findAllByStates(String states);
    //    @Query(value = "select f from JobOpening as f where f.companyName=:name",nativeQuery = true)
    List<JobAdvertisement>findAllByCompany(String company);


}
