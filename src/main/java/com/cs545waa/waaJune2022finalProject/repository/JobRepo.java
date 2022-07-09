package com.cs545waa.waaJune2022finalProject.repository;

import com.cs545waa.waaJune2022finalProject.dto.JobAdvertisementDto;
import com.cs545waa.waaJune2022finalProject.entity.JobAdvertisement;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepo extends CrudRepository<JobAdvertisement,Integer> {
//    public List<JobAdvertisement> findAllBy
    @Query("select job from JobAdvertisement job join job.address ad join job.tags tag where 1=1 OR tag.name =?1 OR ad.state = ?2 OR ad.city = ?3 OR job.companyName = ?4")
    List<JobAdvertisementDto> findByFilter(String tag, String state, String city, String companyName);
}
