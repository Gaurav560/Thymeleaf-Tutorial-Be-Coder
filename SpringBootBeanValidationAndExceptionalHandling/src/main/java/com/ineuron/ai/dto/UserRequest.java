package com.ineuron.ai.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserRequest {

	
	//validations
	@NotEmpty
	@Size(min = 4, message = "username must be of 4 characters minimum")
	private String userName;

	@NotEmpty
	@Email
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "email address must be valid")
	private String email;

	@NotEmpty
	@Size(min = 10, max = 10, message = "mobile number must be of 10 digits")
	private String mobileNo;

	@Min(18)
	@Max(60)
	private Integer age;

	@NotEmpty(message = "nationality mut be correct")
	private String nationality;
}
