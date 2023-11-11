package com.ineuron.ai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ineuron.ai.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	

}
