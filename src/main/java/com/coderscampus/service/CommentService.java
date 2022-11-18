package com.coderscampus.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.domain.Comment;
import com.coderscampus.domain.Task;
import com.coderscampus.domain.User;
import com.coderscampus.repositories.CommentRepository;
import com.coderscampus.repositories.TaskRepository;
import com.coderscampus.repositories.UserRepository;

@Service
public class CommentService {
	
	
		
		@Autowired
		public TaskRepository taskRepo;
	
		@Autowired
		public CommentRepository commentRepo;
		
		@Autowired
		public UserRepository userRepo;
		
		
		
		public void deleteById(Long commentId) {
			commentRepo.deleteById(commentId);
		}
		
		
		
		public List<Comment> findByAllUserId(Long userId) {
			return commentRepo.findAllByUser(userRepo.findById(userId));
		}
		
		public List<Comment> findAllByTask(Long taskId) {
			Task task = taskRepo.findByTaskId(taskId);
			List<Comment> comments = commentRepo.findAllByTask(task);
			
			Collections.reverse(comments);
			return comments;
		}
		

		public Comment createComment(Comment comment, User user, Task task) {
			comment.setUser(user);
			comment.setTask(taskRepo.getOne(task.getTaskId()));
			comment.setDateCreated(LocalDateTime.now());
			return commentRepo.save(comment);
		}
		
		public Comment findById(Long commentId) {
			Optional<Comment> commentOpt = commentRepo.findById(commentId);
			return commentOpt.orElse(new Comment());
		}
		
		public Comment saveComment (Comment comment) {
			return commentRepo.save(comment);		
		}
		
		
}
