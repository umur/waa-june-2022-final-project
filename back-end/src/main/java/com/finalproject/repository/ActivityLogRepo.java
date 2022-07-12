package com.finalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLog extends CrudRepository<ActivityLog, Integer> {
}
