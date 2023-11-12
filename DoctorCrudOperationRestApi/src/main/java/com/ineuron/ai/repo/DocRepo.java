package com.ineuron.ai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ineuron.ai.model.Doctor;

public interface DocRepo extends JpaRepository<Doctor, Integer> 
{

	
}
