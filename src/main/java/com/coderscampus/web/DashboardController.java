package com.coderscampus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.domain.Authorities;
import com.coderscampus.domain.Task;
import com.coderscampus.domain.User;
import com.coderscampus.repositories.UserRepository;
import com.coderscampus.service.AdminService;

import com.coderscampus.service.TaskService;
import com.coderscampus.service.UserService;

@Controller
public class DashboardController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	
	@GetMapping("/")
	public String redirectToDashboard() {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String getDashBoard (@AuthenticationPrincipal User user, ModelMap model) {
		Task newTask = new Task();
		List<Task> taskList = taskService.findAll();
		
		model.put("authorities", user.getAuthorities().iterator().next());
		model.put("newTask", newTask);
		model.put("user", user);
		model.put("email", user.getEmail());
		model.put("tasks", taskList);
		return "dashboard";
	}
	
//	@GetMapping("/profile")
//	public String getProfile (@AuthenticationPrincipal User user, ModelMap model) {
//		model.put("user", user);
//		model.put("email", user.getEmail());
//		return "profile";
//	}
	
//	@PostMapping("/profile")
//	public String postProfile (User user) {
//		Email email = user.getEmail();
//		
//		userService.saveUser(user);
//		userService.saveEmail(user, email);
//		return "redirect:/profile";
//		
//	}
	
	
	
}
