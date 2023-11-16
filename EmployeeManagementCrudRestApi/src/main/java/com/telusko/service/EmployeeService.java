package com.telusko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.exception.UserNotFoundException;
import com.telusko.model.Employee;
import com.telusko.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		Employee employee2 = employeeRepo.save(employee);

		return employee2;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee getEmployeeById(int id) throws UserNotFoundException {
		Employee employee = employeeRepo.findByEmpId(id);
		if (employee != null) {
			return employee;

		} else {
			throw new UserNotFoundException("user with id:: " + id + "not available in records");
		}
	}

	public String deleteEmployeeById(int id) throws UserNotFoundException {
		if (employeeRepo.existsById(id)) {
			employeeRepo.deleteById(id);
			return "record deleted with id :: " + id;
		} else {
			throw new UserNotFoundException("user with id:: " + id + "not available in records");
		}
	}

	public String deleteAllEmployees() {
		employeeRepo.deleteAll();
		return "all records deleted";
	}

	public Employee UpdateEmployeeById(Integer id, Employee newEmployeeDetails) throws UserNotFoundException {
		Employee exisitngEmployeeDetails = employeeRepo.findByEmpId(id);

		if (exisitngEmployeeDetails != null) {
			exisitngEmployeeDetails.setEmpName(newEmployeeDetails.getEmpName());
			exisitngEmployeeDetails.setEmpAddress(newEmployeeDetails.getEmpAddress());
			exisitngEmployeeDetails.setEmpDesignation(newEmployeeDetails.getEmpDesignation());

			employeeRepo.save(exisitngEmployeeDetails);
			return exisitngEmployeeDetails;
		} else {
			throw new UserNotFoundException("user not found with given id " + id);
		}
	}

}
