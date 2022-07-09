package com.cs545waa.waaJune2022finalProject.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepo extends CrudRepository<Cv, Integer> {
}
