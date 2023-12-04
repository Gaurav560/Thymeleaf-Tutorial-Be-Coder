package com.telusko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.payload.UserDto;
import com.telusko.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	// POST FOR CREATING RESOURCE

	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUserMethod(@RequestBody UserDto userDto) {
		return new ResponseEntity<UserDto>(this.userService.createUser(userDto), HttpStatus.CREATED);

	}
	// PUT FOR UPDATING USER
	// DELETE FOR DELETING USER
	// GET FOR GET USER

}
