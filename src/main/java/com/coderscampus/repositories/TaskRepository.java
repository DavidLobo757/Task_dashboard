package com.coderscampus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
		
		@Query("select t from Task t"
				)
		List<Task> findAllByTaskId();
		
		@Query("select t from Task t"
				)
		Task findTaskById(Long taskId);
}
