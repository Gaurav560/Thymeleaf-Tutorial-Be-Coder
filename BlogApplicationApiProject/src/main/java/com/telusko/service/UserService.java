package com.telusko.service;

import java.util.List;

import com.telusko.payload.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, Integer userId);

	UserDto getUserById(int userId);

	void deleteUserByid(int userId);
	
	List<UserDto> getAllUsers();	
}
