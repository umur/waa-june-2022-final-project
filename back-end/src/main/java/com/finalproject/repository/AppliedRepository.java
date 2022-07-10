package com.finalproject.repository;

import com.finalproject.models.Applied;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppliedRepository extends CrudRepository<Applied ,Long> {
}
