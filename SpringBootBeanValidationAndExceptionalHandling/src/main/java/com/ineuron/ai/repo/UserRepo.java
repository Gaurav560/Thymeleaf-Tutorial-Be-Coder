package com.ineuron.ai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ineuron.ai.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUserId(int id);

}
