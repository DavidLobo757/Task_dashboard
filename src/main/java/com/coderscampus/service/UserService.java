package com.coderscampus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coderscampus.domain.Authorities;
import com.coderscampus.domain.Email;
import com.coderscampus.domain.Task;
import com.coderscampus.domain.User;
import com.coderscampus.repositories.AuthoritiesRepository;
import com.coderscampus.repositories.TaskRepository;
import com.coderscampus.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TaskRepository taskRepo;
	
	
	@Autowired
	private AuthoritiesRepository authorityRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User findByUserIdWithEmail(Long id) {
		Optional<User> usersOpt = userRepo.findByUserIdWithEmail(id);
		
		return usersOpt.orElse(new User());
	}
	
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User findByUsernamWithAuthorities(String username) {
		return userRepo.findByUsernameWithAuthorities(username);
	}
	
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}

	public void createUser(User user) {
		
		// Make the password encrypted
		String encryptedPassword =  passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		userRepo.save(user);
		
		// Creates Authorities
		Authorities authority = new Authorities();
		authority.setUser(user);
		authority.setAuthority("ROLE_USER");
		authorityRepo.save(authority);
		userRepo.save(user);
		
		// creates fake email until changed
		Email email = new Email();
		email.setUserId(user.getUserId());
		email.setEmail(user.getUsername());
		email.setUser(user);
		user.setEmail(email);
		userRepo.save(user);
	}
	
	public void saveEmail(User user, Email email) {
		user.setEmail(email);
		userRepo.save(user);
	}

	public User getUserByTaskId(Long taskId) {
		Task task = taskRepo.findByTaskId(taskId);
		User user = userRepo.findByUserId(task.getUser().getUserId());
		return user;
	}
	
	
	
}
