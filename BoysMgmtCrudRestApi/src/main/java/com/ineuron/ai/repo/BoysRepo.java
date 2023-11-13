package com.ineuron.ai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ineuron.ai.model.Boy;

public interface BoysRepo extends JpaRepository<Boy, Integer> {

}
