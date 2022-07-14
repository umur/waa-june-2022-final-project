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

   @Query("select f from JobAdvertisement as f  order by f.posted desc ")
      List<JobAdvertisement> findAllByPostedDate();


//    @Query(value="select  * from JobAdvertisement  order by postedDate desc  =:limit", nativeQuery=true)
//
//    List<JobAdvertisement>findAllRecentAp(@Param("limit")  int limit);


    @Query("select  f from JobAdvertisement as f JOIN f.tags as r  where r.name=:tag")
    List<JobAdvertisement>findAllByTags_name(String tag);



 Integer  countAllByCity(String city);

   Integer countAllByStates(String state);


   Integer countByTags(String tag);



    List<JobAdvertisement>findAllByCity(String city);

    List<JobAdvertisement>findAllByStates(String states);
    //    @Query(value = "select f from JobOpening as f where f.companyName=:name",nativeQuery = true)
    List<JobAdvertisement>findAllByCompany(String company);


}
