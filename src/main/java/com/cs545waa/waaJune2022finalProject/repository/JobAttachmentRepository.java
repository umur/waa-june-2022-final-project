package com.cs545waa.waaJune2022finalProject.repository;


import com.cs545waa.waaJune2022finalProject.entity.JobAttachment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAttachmentRepository extends CrudRepository<JobAttachment,Integer > {

    @Query("SELECT name FROM JobAttachment where jobAdvertisement.id =?1")
    String findNameByJobAdvertisementId(Integer id);


//    @Query("SELECT new com.cs545waa.waaJune2022finalProject.dto.JobCount(j.companyname, COUNT(c.year)) "
//            + "FROM JobAdvertisement AS j GROUP BY c.year ORDER BY c.year DESC")
//    List<CommentCount> countTotalCommentsByYearClass();
}
