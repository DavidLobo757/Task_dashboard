package com.coderscampus.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.domain.Comment;
import com.coderscampus.domain.Task;
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
		
		public Comment findByCommentId(Long commentId) {
			return commentRepo.findByCommentId(commentId);
		}
		
		public List<Comment> findByAllUserId(Long userId) {
			return commentRepo.findAllByUser(userRepo.findById(userId));
		}
		
		public List<Comment> findByAllTask(Long taskId) {
			Task task = taskRepo.findTaskById(taskId);
			List<Comment> comments = commentRepo.findAllByPost(task);
			
			Collections.reverse(comments);
			return comments;
		}
		
		public void createComment() {
			Comment comment = new Comment();
			comment.setCommentMessaage(comment.getCommentMessaage());
			
		}
		
		
}
