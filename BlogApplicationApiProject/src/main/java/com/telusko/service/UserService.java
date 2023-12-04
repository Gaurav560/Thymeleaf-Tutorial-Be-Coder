package com.telusko.service;

import java.util.List;

import com.telusko.exception.ResourceNotFoundException;
import com.telusko.payload.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, Integer userId) throws ResourceNotFoundException;

	UserDto getUserById(int userId) throws ResourceNotFoundException;

	void deleteUserByid(int userId) throws ResourceNotFoundException;
	
	List<UserDto> getAllUsers();	
}
