package com.telusko.controller;

import java.util.List;

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

import com.telusko.exception.UserNotFoundException;
import com.telusko.model.Employee;
import com.telusko.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class HomeController {

	//
	@Autowired
	private EmployeeService employeeService;

	// create record of employee
	@PostMapping("/createEmployeeRecord")
	public ResponseEntity<Employee> createNewEmployee(@RequestBody @Valid Employee employee) {

		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.OK);

	}

	// getting all employee details
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployeeDetails() {

		return ResponseEntity.ok(employeeService.getAllEmployees());

	}

	// getting employee record by id
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) throws UserNotFoundException {

		return ResponseEntity.ok(employeeService.getEmployeeById(id));

	}

	// delete employee record by id
	@DeleteMapping("/deleteEmployeeById/{id}")
	public String deleteEmployeeById(@PathVariable Integer id) throws UserNotFoundException {
		return employeeService.deleteEmployeeById(id);

	}

	// delete all employee records
	@DeleteMapping("/deleteAllRecords")
	public String deleteAllEmployeeRecord() {
		return employeeService.deleteAllEmployees();

	}

	// update employee record by id
	@PutMapping("/updateEmployeeRecordWithId/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable Integer id,
			@RequestBody Employee newEmployeeDetails) throws UserNotFoundException {

		return ResponseEntity.ok(employeeService.UpdateEmployeeById(id, newEmployeeDetails));

	}
}
