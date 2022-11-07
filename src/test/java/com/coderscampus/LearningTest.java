package com.coderscampus;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class LearningTest {
	@Test
	public void encrypt_password () {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String encodedPassword = passwordEncoder.encode("dude");
		
		System.out.println(encodedPassword);
		// $2a$10$PDaMCuS5xlBz8srZgG72UeJoCOdDvzPGJFQUfIO2DIZLSEW0QW6e2
		// dude
	}
}
