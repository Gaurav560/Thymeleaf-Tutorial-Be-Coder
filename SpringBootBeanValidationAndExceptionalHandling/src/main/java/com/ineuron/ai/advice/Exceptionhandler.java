package com.ineuron.ai.advice;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ineuron.ai.exception.UserNotFoundException;

@RestControllerAdvice
public class Exceptionhandler {

	// we are telling spring boot whenever u are getting exception with that class
	// name
	// just redirect with the request to this method

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
		Map<String, String> errorMap = new HashMap<>();

		// return the Binding result that this exception wraps
		// getFieldErrors return a list of fields having errors
		// we iterate the list with for each and using lambda expression
		// we put every error with their suitable message in erroMap
		exception.getBindingResult().getFieldErrors()
				.forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));

		return errorMap;

	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> handleUserNotFoundById(UserNotFoundException exception1){
		Map<String, String> errorMap2 = new HashMap<>();
		errorMap2.put("errorMessage", exception1.getMessage());
		return errorMap2;
		
	}

}
