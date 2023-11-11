package com.springboot.financialplanning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enums.Role;

import com.springboot.financialplanning.exception.InvalidIdException;
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
		/* save user info in db */
		User user = executive.getUser();
		String passwordPlain = user.getPassword();
		String encodedPassword = passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);

		user.setRole(Role.EXECUTIVE);
		user = userService.insert(user);

		executive.setUser(user);

		return executiveService.insert(executive);
	}

	@GetMapping("/all")
	public List<Executive> getAllExecutives() {
		List<Executive> list = executiveService.getAllExecutives();
		return list;
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<?> getExecutiveById(@PathVariable("id") int id) {
		try {
			Executive executive = executiveService.getExecutiveById(id);
			return ResponseEntity.ok().body(executive);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteExecutive(@PathVariable("id") int id) {
		try {
			Executive executive = executiveService.getExecutiveById(id);
			executiveService.deleteExecutive(executive.getId());
			return ResponseEntity.ok().body("executive Record deleted");
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateExecutive(@PathVariable("id") int id, 
			@RequestBody Executive newexecutive) {
		try {
			Executive executive = executiveService.getExecutiveById(id);
			if(newexecutive.getName() != null)
				executive.setName(newexecutive.getName());
			if(newexecutive.getEmail() != null)
				executive.setEmail(newexecutive.getEmail());
			if(newexecutive.getCity() != null)
				executive.setCity(newexecutive.getCity());
			
				executive = executiveService.insert(executive);
			return ResponseEntity.ok().body(executive);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}