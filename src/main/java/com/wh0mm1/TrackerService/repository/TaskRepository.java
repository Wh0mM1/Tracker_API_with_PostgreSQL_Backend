package com.wh0mm1.TrackerService.repository;

import com.wh0mm1.TrackerService.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
