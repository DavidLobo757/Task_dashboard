package com.coderscampus.web;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.domain.Comment;
import com.coderscampus.domain.Task;
import com.coderscampus.domain.User;
import com.coderscampus.service.CommentService;
import com.coderscampus.service.TaskService;
import com.coderscampus.service.UserService;

@Controller
public class CommentController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/task/{taskId}/createComment" )
	public String getComment(ModelMap model, @AuthenticationPrincipal User user,@PathVariable Long taskId) {
		Comment comment = new Comment();
		Task task = taskService.findById(taskId);
		model.put("comment", comment);
		model.put("currentUser", user);
		model.put("currentTask", task);
		return "createComment";
	}
	
	@GetMapping("/comment/{commentId}") 
	public String editComment(ModelMap model, @AuthenticationPrincipal User user, @PathVariable Long commentId) {
		Comment comment = commentService.findById(commentId);
//		User user = userService.findByUserIdWithEmail(comment.getUser());
		model.put("comment", comment);
		model.put("currentUser", user);
		return "editComment";
	}
	
	@PostMapping("/comment/{commentId}/updateComment")
	public String editingComment(Comment comment, @AuthenticationPrincipal User user) {
		commentService.saveComment(comment);
		Task task = comment.getTask();
		Long taskId = task.getTaskId();
		return "redirect:/task/" + taskId;
	}
	
	@PostMapping("/creatingComment")
	public String createComment(Comment comment,  User user, Task task) {
		commentService.createComment(comment, user, task);
		long taskId = task.getTaskId();
		String url = "/task/" + taskId;
		return "redirect:" + url;
	}	
	
	@PostMapping("/task/{taskId}/comment/{commentId}/delete")
	public String deleteTask(@PathVariable Long taskId, @PathVariable Long commentId) {
		commentService.deleteById(commentId);
		String Url = "/task/" + taskId;
		return "redirect:" + Url;
	}
	
}
