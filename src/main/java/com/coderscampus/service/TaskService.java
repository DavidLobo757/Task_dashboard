package com.coderscampus.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.domain.Task;
import com.coderscampus.domain.User;
import com.coderscampus.repositories.TaskRepository;

@Service
public class TaskService {
	
		@Autowired
		private TaskRepository taskRepo;
		
		public Task createTask(User user, Task task) {
				task.setDateCreated(LocalDateTime.now());
				task.setUser(user);
				
				return taskRepo.save(task);
		}
		
		public void deleteById(Long TaskId) {
			taskRepo.deleteById(TaskId);
		}
		
		public List<Task> findAll() {
			List<Task> tasks = taskRepo.findAllByTaskId();
			return tasks;
		}
		
		public Optional<Task> findById(Long taskId) {
			return taskRepo.findById(taskId);
		}
}
