package com.coderscampus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
		
		List<Task> findAllByTaskId();
		
		Task findTaskById(Long taskId);
}
