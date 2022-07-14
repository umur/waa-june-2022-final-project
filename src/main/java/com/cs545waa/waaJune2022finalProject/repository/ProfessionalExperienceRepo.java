package com.cs545waa.waaJune2022finalProject.repository;

import com.cs545waa.waaJune2022finalProject.entity.ProfessionalExperience;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProfessionalExperienceRepo extends CrudRepository<ProfessionalExperience,Integer> {
    //@Query("delete from professional_experience_tags s where  s.professional_experience_id=?1")
    public void removeByTags(Integer experienceId);
}
