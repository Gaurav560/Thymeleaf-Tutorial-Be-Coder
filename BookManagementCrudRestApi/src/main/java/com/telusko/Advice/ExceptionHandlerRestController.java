package com.telusko.Advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.telusko.Exception.BookNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerRestController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodArgumentNoyValidHandler(MethodArgumentNotValidException exception) {

		Map<String, String> errorMsg = new HashMap<>();

		// BindingResult is a class
		// return the Binding result object that this exception wraps
		// getFieldErrors return a list of fields having errors
		// we iterate the list with for each and using lambda expression
		// we put every error with their suitable message in erroMap
		exception.getBindingResult().getFieldErrors()
				.forEach(error -> errorMsg.put(error.getField(), error.getDefaultMessage()));

		return errorMsg;

	}

	
	
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookNotFoundException.class)
	public Map<String, String> bookNotFoundHandler(BookNotFoundException exception) {
		Map<String, String> errorMsg = new HashMap<>();
		errorMsg.put("errorMessage", exception.getMessage());
		return errorMsg;
	}
	
	
	
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public Map<String, String> generalExceptionHandler(Exception exception) {
		Map<String, String> errorMsg = new HashMap<>();
		errorMsg.put("errorMessage", exception.getMessage());
		return errorMsg;
	}
}
