package com.telusko.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.entity.User;
import com.telusko.exception.ResourceNotFoundException;
import com.telusko.payload.UserDto;
import com.telusko.repo.UserRepo;
import com.telusko.service.UserService;

//implementation class of UserService Interface
@Service
public class UserServiceImpl implements UserService {

	// injecting userRepo object with @Autowired annotation
	// so that i can use its inbuilt methods
	@Autowired
	private UserRepo userRepo;

	// method for creating a user
	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.dtoToEntity(userDto);
		User savedUser = this.userRepo.save(user);
		return this.entityToDto(savedUser);
	}

	// method for updating a user using his/her id
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) throws ResourceNotFoundException {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		user.setName(userDto.getName());
		user.setUserEmail(userDto.getUserEmail());
		user.setUserPassword(userDto.getUserPassword());
		user.setUserDetail(userDto.getUserDetail());

		return this.entityToDto(user);

	}

	// method for getting a user using his/her id
	@Override
	public UserDto getUserById(int userId) throws ResourceNotFoundException {
		
		 User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "id", userId));
		return this.entityToDto(user);
	}

	// method for deleting a user using his/her id
	@Override
	public void deleteUserByid(int userId) throws ResourceNotFoundException {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		this.userRepo.delete(user);

	}

	// method for getting all users in db table
	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();

//using stream api to map user into userDto
		List<UserDto> userDtos = users.stream().map(user -> this.entityToDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	// making Model Mapper methods to convert the user from dto and vice-versa

	// method to convert userDto to User entity object
	public User dtoToEntity(UserDto userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setName(userDto.getName());
		user.setUserDetail(userDto.getUserDetail());
		user.setUserEmail(userDto.getUserEmail());
		user.setUserPassword(userDto.getUserPassword());

		return user;
	}

	// method to convert userEntity to userDto object
	public UserDto entityToDto(User user) {
		UserDto userDto2 = new UserDto();
		userDto2.setUserId(user.getUserId());
		userDto2.setName(user.getName());
		userDto2.setUserDetail(user.getUserDetail());
		userDto2.setUserPassword(user.getUserPassword());
		userDto2.setUserEmail(user.getUserEmail());

		return userDto2;

	}

}
