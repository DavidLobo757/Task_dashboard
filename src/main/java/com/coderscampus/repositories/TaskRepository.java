package com.coderscampus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.domain.Comment;
import com.coderscampus.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
		
		List<Task> findAllByOrderByTaskId();
		
		
		Task findByTaskId(Long taskId);
		
		Task findByName(String name);
		
		@Query("select t from Task t"
				+ " left join fetch t.comment"
				)
		Optional<Task> findByTaskWithComments(Long taskId);
		
		
		
//		Comment<Task> findAllTasksWithComment(Task task);
}
