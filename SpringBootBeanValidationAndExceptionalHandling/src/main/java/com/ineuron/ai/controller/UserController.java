package com.ineuron.ai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ineuron.ai.dto.UserRequest;
import com.ineuron.ai.entity.User;
import com.ineuron.ai.exception.UserNotFoundException;
import com.ineuron.ai.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signUp")
	public ResponseEntity<User> saveUser (@RequestBody @Valid UserRequest userRequest) {

		return new ResponseEntity<User>(userService.saveUser(userRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
		return ResponseEntity.ok(userService.getUser(id));
	}
}
