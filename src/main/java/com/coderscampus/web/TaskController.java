package com.coderscampus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.domain.Task;
import com.coderscampus.domain.User;
import com.coderscampus.service.CommentService;
import com.coderscampus.service.TaskService;
import com.coderscampus.service.UserService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping("/task/{taskId}")
	public String getTask(ModelMap model, @PathVariable Long taskId, @AuthenticationPrincipal User user) {
		
		
		model.put("task", taskService.findById(taskId));
		model.put("currentUser", user);
		model.put("userTask", userService.getUserByTaskId(taskId));
		model.put("comments", commentService.findAllByTask(taskId));
		return "task";
	}
	
	@GetMapping("/task/creatingTask")
	public String creatingTask(ModelMap model, @AuthenticationPrincipal User user) {
		Task task = new Task();
		model.put("task", task);
		model.put("currentUser", user);
		return "createTask";
		
	}
	
	@PostMapping("/createTask")
	public String createTask(Task task, User user) {
		taskService.createTask(user, task);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/dashboard/{taskId}/delete")
	public String deleteTask(@PathVariable Long taskId) {
		
		return "redirect:/dashboard";
	}
//	
//	@PostMapping("/createTask")
//	public String createTask(@AuthenticationPrincipal User user, Task task) {
//		System.out.println("Creating task");
//		taskService.createTask(user, task);
//		return "redirect:/dashboard";
//	}
	
}
