package com.telusko.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int empId;
	
	//validations on user input fields
	
	
	@NotEmpty
	@Size(min = 2,message = "name be  greater than 1 characters")
	private String empName;
	
	
	
	@NotEmpty(message = "salary can't be empty or null")
	@Min(30000)
	@Max(100000)
	private String empSalary;
	
	
	
	@NotEmpty(message = "employee Designation can't be empty or null")
	private String empDesignation;
	
	
	
	
	@Max(55)
	@Min(18)
	private String empAge;
	
	
	
	@Email
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "email must be properly filled")
	private String empEmail;

	
	
	
	@Size(min = 10, max = 10,message = "mobile number must be of 10 digits")
	private String empNumber;
	
	
	
	
	@NotEmpty(message = "please input correct home address")
	private String empAddress;
	
}
