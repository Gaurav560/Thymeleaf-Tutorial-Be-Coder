package com.telusko.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
