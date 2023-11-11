package com.springboot.financialplanning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enums.Role;
import com.springboot.financialplanning.model.Company;
import com.springboot.financialplanning.model.Executive;
import com.springboot.financialplanning.model.User;
import com.springboot.financialplanning.service.ExecutiveService;
import com.springboot.financialplanning.service.UserService;

@RestController
@RequestMapping("/executive")
public class ExecutiveController {
	
	@Autowired
	ExecutiveService executiveService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/add")
	public Executive insertExecutive(@RequestBody Executive executive) {
		/*save user info in db*/
		User user=executive.getUser();
		String passwordPlain=user.getPassword();
		String encodedPassword=passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
		
		user.setRole(Role.EXECUTIVE);
		user=userService.insert(user);
		
		executive.setUser(user);
		
		return executiveService.insert(executive);
	}
	
	
}