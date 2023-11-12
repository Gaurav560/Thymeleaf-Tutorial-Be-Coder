package com.ineuron.ai.Controller;

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

import com.ineuron.ai.model.Doctor;
import com.ineuron.ai.repo.DocRepo;

@RestController
@RequestMapping("/api")
public class DocController {
	@Autowired
	DocRepo docRepo;
	
//	store doc object 
	@PostMapping("/allDoctors")
	public String storeAllDoctors(@RequestBody Doctor doctor ) {
		docRepo.save(doctor);
		return "doctor details stored in db";
		
	}
	
	//get all objects
	@GetMapping("/allDoctors")
	public ResponseEntity<List<Doctor>> getAllDoctors(){
		List<Doctor> list=new ArrayList<>();
		docRepo.findAll().forEach(list::add);
		 return new ResponseEntity<List<Doctor>> (list,HttpStatus.OK);
		
	}
	
	//get By ID
	@GetMapping("/allDoctors/{doc_Id}")
	public ResponseEntity<Doctor> getDocById(@PathVariable Integer doc_Id){
		Optional<Doctor> doc=docRepo.findById(doc_Id);
		if (doc.isPresent()) {
			
			return new ResponseEntity<Doctor>(doc.get(),HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
		}
	}
	
	//update by id
	@PutMapping("/allDoctors/{doc_Id}")
	public String updateById(@PathVariable Integer doc_Id,@RequestBody Doctor doctor) {
		Optional<Doctor> doc=docRepo.findById(doc_Id);
		if (doc.isPresent()) {
			Doctor existingDoctor=doc.get();
			existingDoctor.setDoc_Name(doctor.getDoc_Name());
			existingDoctor.setDoc_Salary(doctor.getDoc_Salary());
			docRepo.save(existingDoctor);
			return "updated doctor object ";
			
		}else {
			return "doctor details not updated.";
		}
	}
		
		//delete by id
		@DeleteMapping("/allDoctors/{doc_Id}")
		public String deleteBYId(@PathVariable Integer doc_Id)
		{
			docRepo.deleteById(doc_Id);
			return "doctor details updated successfully.";
		}
		
		//delete all doctor objects
		@DeleteMapping("/allDoctors")
		public String deleteAllDoctors() {
			docRepo.deleteAll();
			return "all doctor details deleted successfully";
		}
	
	}

	
	

