package com.ineuron.ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ineuron.ai.dto.UserRequest;
import com.ineuron.ai.entity.User;
import com.ineuron.ai.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	// save all user
	public User saveUser(UserRequest userRequest) {
		User user = User.build(0, userRequest.getUserName(), userRequest.getEmail(), userRequest.getMobileNo(),
				userRequest.getAge(), userRequest.getNationality());
		return userRepo.save(user);
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User getUser(int id) {
		return userRepo.findByUserId(id);
	}
}
