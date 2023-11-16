package com.telusko.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByEmpId(int id);

}
