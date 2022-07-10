package com.finalproject.repository;

import com.finalproject.models.Tags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepo extends CrudRepository<Tags, Long> {
}
