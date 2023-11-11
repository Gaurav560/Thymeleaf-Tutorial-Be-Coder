package com.ineuron.ai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ineuron.ai.model.Employee;

//jpa mein first argument rahega model ka class name and 2nd argument primary key ka return type
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	

}
