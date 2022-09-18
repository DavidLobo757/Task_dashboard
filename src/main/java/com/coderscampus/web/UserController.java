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
	
	
	@GetMapping("/create")
	public String createUser(ModelMap model) {
		model.put("user", new User());
		return "create";
	}
	
	@PostMapping("/create")
	@ResponseBody
	public String postCreateUser(@RequestBody User user) {
		userService.createUser(user);
		System.out.println(user);
		System.out.println(user.getAuthorities());
		System.out.println(user.getEmail());
		System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
		return "redirect:/users/" + user.getId();
		// whenever you come back to this make sure that the redirect will be going to the user as /users/{id}
	}
	
	
	@GetMapping("/users/exists")
	@ResponseBody
	public Boolean getExists(String username,String password) {
		System.out.println("Username = " + username + ", Password = " + password);
		return true;
	}
	
	@PostMapping("/users/exists")
	@ResponseBody
	public Boolean postExists (@RequestBody User user) {
		System.out.println("Username = " + user.getUsername() + ", Password = " + user.getPassword());
		return true;
	}
	//
	@GetMapping("/users/validateUsername")
	@ResponseBody
	public Boolean getValidUsername(@RequestBody User user) {
		user = userService.findByUsername(user.getUsername());
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
		return "redirect:/users/" + currentUser.getId();
	}
	
	
}
