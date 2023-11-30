package com.telusko.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

	// we can expose this class data directly to any api.we don't want to expose the
	// user class data directly to api
	// due to security purposes as it exposes the data directly.
	//entity classes are directly related to database table so ,we dont want to use entity class
	//object for transferring of data.
	private int userId;
	private String name;
	private String userEmail;
	private String userPassword;
	private String userDetail;
}
