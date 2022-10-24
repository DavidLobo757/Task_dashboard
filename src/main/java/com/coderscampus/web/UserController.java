package com.coderscampus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.domain.User;
import com.coderscampus.repositories.UserRepository;
import com.coderscampus.service.AdminService;
import com.coderscampus.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/register")
	public String getRegister(ModelMap model) {
		User user  = new User();
		
		model.put("user", user);
		return "register";
		
	}
	
	@PostMapping("/register")
	public String postRegister (User user) {
		userService.createUser(user);
		return "redirect:/users/" + user.getUserId();
		
	}
	
	@PostMapping("/users/exists")
	@ResponseBody
	public Boolean postExists(@RequestBody User user) {
		user = userService.findByUsername(user.getUsername());
		return user != null;
	}
	

	@GetMapping("/users/validateUsername")
	@ResponseBody
	public Boolean getValidUsername( User user) {
		
		System.out.println("Username = " + user.getUsername());
		return true;
	}
	
	@GetMapping("/users/validatePassword")
	@ResponseBody
	public Boolean getValidPassword(User user) {
		System.out.println("Password = " + user.getPassword());
		return true;
	}
	//
	
	@GetMapping("/users")
	public String getUsers(ModelMap model) {
		return "users";
	}
	
	
	@GetMapping("/users/{id}")
	public String getUser(ModelMap model, @PathVariable Long id) {
		User currentUser = userService.findByUserIdWithEmail(id);
		model.put("user", currentUser);
		return "users";
	}
	
	
	@PostMapping("/users/{id}")
	public String postUser (@PathVariable Long id) {
		User currentUser = userService.findByUserIdWithEmail(id);
		return "redirect:/users/" + currentUser.getUserId();
	}
	
	
}
