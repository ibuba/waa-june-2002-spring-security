package com.edu.miu.repository;

import com.edu.miu.Domain.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends CrudRepository<ActivityLog,Integer> {
}
