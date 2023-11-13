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

import com.ineuron.ai.model.Boy;
import com.ineuron.ai.repo.BoysRepo;

@RestController
@RequestMapping("/api")
public class HomeController {

	@Autowired
	private BoysRepo boysRepo;

	// store data in db
	@PostMapping("/allBoys")
	public String storeBoys(@RequestBody Boy boy) {
		boysRepo.save(boy);
		return "object stored successfully.";
	}
	
	
	//get all boys
	@GetMapping("/allBoys")
	public ResponseEntity<List<Boy>> getAllBoys(){
		List<Boy> list=new ArrayList<>();
		boysRepo.findAll().forEach(list::add);
		return new ResponseEntity<List<Boy>>(list,HttpStatus.OK);
	}
	
	//get by id
	@GetMapping("/allBoys/{id}")
	public ResponseEntity<Boy> getBoyById(@PathVariable Integer id){
		Optional<Boy> boy=boysRepo.findById(id);
		if (boy.isPresent()) {
			return new ResponseEntity<Boy>(boy.get(),HttpStatus.FOUND);
			
		}else {
			return new ResponseEntity<Boy>(HttpStatus.NOT_FOUND);
		}
	}
	
	//update by id
	@PutMapping("/allBoys/{id}")
	public String updateById(@PathVariable Integer id,@RequestBody Boy boy3) {
		Optional<Boy> boy=boysRepo.findById(id);
		if (boy.isPresent()) {
			Boy existingBoy=boy.get();
			existingBoy.setStandard(boy3.getStandard());
			boysRepo.save(existingBoy);
			return "boy details updated";
			
		}
		else {
			return "not updated";
		}
		
	}
	//delete by id
	@DeleteMapping("/allBoys/{id}")
	public String deleteById(@PathVariable Integer id) {
		boysRepo.deleteById(id);
		return "deleted by id";
	}
	//delete all
	@DeleteMapping("/allBoys")
	public String deleteAll() {
		boysRepo.deleteAll();
		return "deleted all";
	}
	
	

}
