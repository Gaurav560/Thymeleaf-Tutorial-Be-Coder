package com.telusko.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.model.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
	
	
	

	
	
}
