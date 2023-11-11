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

import com.ineuron.ai.Repo.StudentRepo;
import com.ineuron.ai.model.Student;

@RestController
@RequestMapping("/studentApi")
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;

	//method for storing
	@PostMapping("/storeStudentDetails")
	public String createStudentDetails(@RequestBody Student student) {
		studentRepo.save(student);
		
		return "records created for student";
	}
	
	//method for fetching all the records
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudentDetails(){
	
		List<Student> list=new ArrayList<>();
		studentRepo.findAll().forEach(list::add);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	//select student by Id
	@GetMapping("/getAllStudents/{std_Id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer std_Id){
		
	Optional<Student> std=studentRepo.findById(std_Id);
	if (std.isPresent()) {
		return new ResponseEntity<Student>(std.get(),HttpStatus.OK);
	}else {
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}
	
	}
	
	//update student object details
	@PutMapping("/getAllStudents/{std_Id}")
	public String updateStudentDetails(@PathVariable Integer std_Id,@RequestBody Student student) 
	{
		Optional<Student> std=studentRepo.findById(std_Id);
		if (std.isPresent()) {
			Student existingStudent=std.get();
			existingStudent.setStd_Age(student.getStd_Age());
			existingStudent.setStd_Name(student.getStd_Name());
			studentRepo.save(existingStudent);
			return "student details with id"+std_Id+"is updated";
			
		}else {
			return "student details with that id "+std_Id+"has not been found";
		}
		
	}
	
	//delete by id
	@DeleteMapping("/getAllStudents/{std_Id}")
	public String deleteBYId(@PathVariable Integer std_Id) {
		studentRepo.deleteById(std_Id);
		return "student details with id"+std_Id+" deleted successfully";
		
	}
	
//	delete all
	@DeleteMapping("/getAllStudents")
	public String deleteAllStudentDetails() {
		studentRepo.deleteAll();
		return "all records of student table deleted successfully.";
	}
	
	

}
