package com.ineuron.ai.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ineuron.ai.model.Athletedetails;

public interface AthleteRepo extends JpaRepository<Athletedetails, Integer> {

}
