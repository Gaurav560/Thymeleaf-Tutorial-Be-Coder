package com.ineuron.ai.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ineuron.ai.model.Employee;
import com.ineuron.ai.repo.EmployeeRepo;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	//object khud se generate karne ki jarurat nahi hai ,spring khud se hi generate kar ke dega
	//object bana rahe hai kyunki inbuit methods ko call kar sake jpa repo ka 
	@Autowired
	EmployeeRepo employeeRepo;
	
	//for storing employee
	@PostMapping("employee")
	public String createNewEmployee(@RequestBody Employee employee) {
 employeeRepo.save(employee);
		return "Employee created in db";
	}
	
	//for getting all employee details
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list=new ArrayList<>();
		employeeRepo.findAll().forEach(list::add);
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	//optional functional interface ka concept aisa hai ki ,agar hm dataabse se data rtrieve kar rahe hain aur wo exist nahi 
	//karta hai ,to hume null pointer throw kar sakta hai.
	
	
	
	//retrieve object through id
	@GetMapping("/employee/{emp_Id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer emp_Id){
		Optional<Employee> empOptional=employeeRepo.findById(emp_Id);
		if (empOptional.isPresent()) {
			return new ResponseEntity<Employee>(empOptional.get(),HttpStatus.FOUND);}
		else {
				return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	
	//put method for update
	@PutMapping("/employee/{emp_Id}")
	public String updateEmployeeById(@PathVariable Integer emp_Id,@RequestBody Employee employee) {
		
		//findBYId return object which we store in optional class object to deal with null pointer exception 
		Optional<Employee> emp= employeeRepo.findById(emp_Id);
		if (emp.isPresent()) {
			Employee existingEmployee=emp.get();
			existingEmployee.setEmp_Name(employee.getEmp_Name());
			existingEmployee.setEmp_City(employee.getEmp_City());
			existingEmployee.setEmp_Salary(employee.getEmp_Salary());
			existingEmployee.setEmp_Age(employee.getEmp_Age());
			employeeRepo.save(existingEmployee);
			return "Employee details against id"+emp_Id+"updated";
		}
		else {
			return "employee details against"+emp_Id+"does not exists";
		}
	}
	
	//delete the employee id
	@DeleteMapping("/employee/{emp_Id}")
	public String deleteById(@PathVariable Integer emp_Id) {
		 employeeRepo.deleteById(emp_Id);
		 return "Employee deted successfully";
	}
	
	
	//delete all emp
	@DeleteMapping("/employeezzz")
	public String deleteAll() {
		employeeRepo.deleteAll();
		return "all employees details deleted successfully";
	}
	
	
	

}
