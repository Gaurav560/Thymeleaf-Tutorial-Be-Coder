package com.ineuron.ai.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ineuron.ai.model.Athletedetails;
import com.ineuron.ai.repo.AthleteRepo;

@RestController
@RequestMapping("/api")
public class AthleteController {
	
	@Autowired
	AthleteRepo athleteRepo;
	
//store athlete details
	@PostMapping("/getAllAthletes")
	public String storeAthleteDetails(@RequestBody Athletedetails athlete) {
		
	athleteRepo.save(athlete);
	return "object saved successfully.";
	}
	
	@GetMapping("/getAllAthletes")
	public ResponseEntity<List<Athletedetails>> getAllAthletes(){
		List<Athletedetails> list=new ArrayList<>();
		athleteRepo.findAll().forEach(list::add);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	//get Athlete details by id
	@GetMapping("/getAllAthletes/{ath_id}")
	public ResponseEntity<Athletedetails> getById(@PathVariable Integer ath_id){
		Optional<Athletedetails> ath=athleteRepo.findById(ath_id);
		if (ath.isPresent()) {
			return new ResponseEntity<Athletedetails>(ath.get(),HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<Athletedetails>(HttpStatus.NOT_FOUND);
		}
	}
	
	//update by id
	@PutMapping("/getAllAthletes/{ath_id}")
	public String updateById(@PathVariable Integer ath_id, @RequestBody Athletedetails athlete) {
		Optional<Athletedetails> ath=athleteRepo.findById(ath_id);
		if (ath.isPresent()) 
		{
			Athletedetails existingAthlete=ath.get();
			existingAthlete.setAth_Age(athlete.getAth_Age());
			existingAthlete.setAth_Name(athlete.getAth_Name());
			athleteRepo.save(existingAthlete);
			return "updated";
			
		}else {
			return "not updated";
		}
	}
	
	//delete by id
	@DeleteMapping("/getAllAthletes/{ath_id}")
	public String deleteById(@PathVariable Integer ath_id) {
		athleteRepo.deleteById(ath_id);
		return "id "+ath_id+"deleted permanently";
		
	}
	
	
	//delete all table
		@DeleteMapping("/getAllAthletes")
		public String deleteAll() {
			athleteRepo.deleteAll();
			return "deleted permanently";
			
		}
	
	
	
}
