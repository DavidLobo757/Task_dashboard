package com.coderscampus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.domain.User;
import com.coderscampus.repositories.UserRepository;
import com.coderscampus.service.AdminService;
import com.coderscampus.service.UserService;

@Controller
public class DashboardController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String redirectToDashboard() {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String getDashBoard (@AuthenticationPrincipal User user, ModelMap model, Long id) {
		List<User> allUserAccounts = adminService.getAllUserAccounts();
		
		
		
		model.put("user", user);
		model.put("email", user.getEmail());
		
		
		return "dashboard";
	}
	
	
	
	
	
}
